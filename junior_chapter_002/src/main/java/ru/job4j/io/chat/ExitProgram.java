package ru.job4j.io.chat;

public class ExitProgram implements Action {
    @Override
    public void execute(Chat chat) {
        chat.setState(ChatState.EXIT);
    }
}