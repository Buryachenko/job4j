package ru.job4j.httpdownload;

import java.io.IOException;
import java.util.List;

public class Hget {

    public static void main(String[] args) throws InterruptedException, IOException {
        List<String> list = List.of(args);
        String fileURL = list.get(0);
        String rate = list.get(1);
        Thread thread = new Thread(new Download(fileURL, rate));
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}