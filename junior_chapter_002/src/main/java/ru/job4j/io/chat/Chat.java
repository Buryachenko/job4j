package ru.job4j.io.chat;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Chat {
    private List<String> lines;
    private Random random = new Random();
    private final int range = 10;
    private enum Console { MESSAGE, STOP }
    private Console state = Console.MESSAGE;
    private String pathsLog;
    public Chat(String pathAsk, String pathLog) {
        this.lines = this.readAllLines(pathAsk);
        this.pathsLog = pathLog;
    }

    private List<String> readAllLines(String path) {
        try {
            return Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

    private void toWriteLog(String name, String msg) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(this.pathsLog, true))) {
            out.println(name + ":       " + msg);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean add(String msg) {
        toWriteLog("User", msg);
        boolean result = true;
        if (msg.equals("стоп")) {
            state = Console.STOP;
        } else if (msg.equals("продолжить")) {
            state = Console.MESSAGE;
        } else if (msg.equals("закончить")) {
            result = false;
        } else if (state == Console.MESSAGE) {
            answerProgram();
        }
        return result;
    }

    private void answerProgram() {
        String msg = this.lines.get(random.nextInt(range));
        toWriteLog("Program", msg);
        System.out.println("Program:");
        System.out.println("    " + msg);
    }
}
