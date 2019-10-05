package ru.job4j.httpdownload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Class that downloads a file from a URL.
 *
 * @author Buryachenko
 * @version 1
 * @since 26.09.2019
 */
public class Download implements Runnable {
    private static final int BUFFER_SIZE = 4096;
    private final String saveDir;
    private String saveFilePath;
    private final long rate;
    private final int sec = 1000;
    private final HttpURLConnection openConnection;

    public Download(String fileURL, String kilobytes) throws IOException {
        this.saveDir = new File("").getAbsolutePath();
        this.rate = 1024 * Long.parseLong(kilobytes);
        this.openConnection = connection(fileURL);
    }

    /**
     *
     * @param fileURL HTTP URL of the file to be downloaded
     * @param kilobytes rate of the file to be downloaded
     * @param saveDir path of the directory to save the file
     * @throws IOException
     */
    public Download(String fileURL, String kilobytes, String saveDir) throws IOException {
        this.saveDir = saveDir;
        this.rate = 1024 * Long.parseLong(kilobytes);
        this.openConnection = connection(fileURL);
    }

    private HttpURLConnection connection(String fileURL) throws IOException {
        URL url = new URL(fileURL);
        HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();
        int responseCode = openConnection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String fileName = "";
            String disposition = openConnection.getHeaderField("Content-Disposition");
            String contentType = openConnection.getContentType();
            int contentLength = openConnection.getContentLength();
            if (disposition != null) {
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    fileName = disposition.substring(index + 10, disposition.length() - 1);
                }
            } else {
                fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1);
            }
            this.saveFilePath = this.saveDir + File.separator + fileName;
            System.out.println("Content-Type = " + contentType);
            System.out.println("Content-Disposition = " + disposition);
            System.out.println("Content-Length = " + contentLength);
            System.out.println("fileName = " + fileName);
        } else {
            System.out.println("No file to download. Server replied HTTP code: " + responseCode);
        }
        return openConnection;
    }

    private void downloadFile() throws IOException {
        InputStream inputStream = this.openConnection.getInputStream();
        FileOutputStream outputStream = new FileOutputStream(this.saveFilePath);
        int bytesRead = -1;
        byte[] buffer = new byte[BUFFER_SIZE];
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            if (!Thread.interrupted()) {
                outputStream.write(buffer, 0, bytesRead);
            } else {
                controlRate();
            }
        }
        outputStream.close();
        inputStream.close();
        System.out.println("File downloaded");
        this.openConnection.disconnect();
    }

    private void controlRate() {
        File file = new File(this.saveFilePath);
        long currentRate = file.length();
        if (this.rate > 0) {
            int pause = (int)((Math.floor(currentRate / this.rate) - 1) * this.sec);
            try {
                Thread.sleep(pause);
                System.out.println("Run sleep " + pause + " ms");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        try {
            downloadFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}