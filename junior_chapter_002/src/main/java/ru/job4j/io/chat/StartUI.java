package ru.job4j.io.chat;

import java.util.function.Consumer;

public class StartUI {
    private boolean exit = true;
    private final Input input;
    private final Consumer<String> output;
    private final Chat chat;

    public StartUI(Input input, Consumer<String> output) {
        this.input = input;
        this.output = output;
        chat = new Chat("AskChat.txt", "LogChat.txt");
    }

    public void init() {
        do {
            this.exit = chat.add(input.ask("User: "));
        } while (this.exit);
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), System.out :: println).init();
    }
}