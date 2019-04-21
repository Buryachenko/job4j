package ru.job4j.io;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Iterator;
/**
 *
 * Class Analizy
 * @athor Buryachenko
 * @since 21.04.19
 * @version 1
 */
public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            Iterator<String> it = read.lines().iterator();
            writeTimeUnavailable(it, target);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeTimeUnavailable(Iterator<String> it, String target) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            String start = "";
            while (it.hasNext()) {
                String str = it.next();
                if ((str.contains("400") || str.contains("500")) && start.isEmpty()) {
                    start = str.substring(4);
                } else  if ((str.contains("200") || str.contains("300")) && !start.isEmpty()) {
                    out.println(start + ";" + str.substring(4));
                    start = "";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}