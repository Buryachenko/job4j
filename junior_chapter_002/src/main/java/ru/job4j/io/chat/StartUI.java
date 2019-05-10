package ru.job4j.io.chat;

import java.util.function.Consumer;

public class StartUI {
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
            chat.add(input.ask("User: "));
        } while (chat.getState() != ChatState.EXIT);
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), System.out :: println).init();
    }
}