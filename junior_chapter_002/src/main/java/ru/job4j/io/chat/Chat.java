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
    private ChatState state = ChatState.MESSAGE;
    private String pathsLog;
    private Map<String, Action> actions = new HashMap<>();

    public Chat(String pathAsk, String pathLog) {
        this.lines = this.readAllLines(pathAsk);
        this.pathsLog = pathLog;
        this.actions.put("отправить сообщение", new SendMessage());
        this.actions.put("стоп", new StopChat());
        this.actions.put("продолжить", new RunChat());
        this.actions.put("закончить", new ExitProgram());
    }

    private List<String> readAllLines(String path) {
        try {
            return Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

    public void toWriteLog(String name, String msg) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(this.pathsLog, true))) {
            out.println(name + ":       " + msg);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void add(String msg) {
        this.actions.get(keyAction(msg)).execute(this);
    }

    private String keyAction(String msg) {
        toWriteLog("User", msg);
        String result = "отправить сообщение";
        for (String key : this.actions.keySet()) {
            if (msg.equals(key)) {
                result = key;
                break;
            }
        }
        return result;
    }

    public String answerProgram() {
        return this.lines.get(random.nextInt(range));
    }

    public void setState(ChatState state) {
        this.state = state;
    }

    public ChatState getState() {
        return this.state;
    }
}
