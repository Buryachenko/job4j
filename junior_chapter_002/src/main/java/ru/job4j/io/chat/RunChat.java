package ru.job4j.io.chat;

public class RunChat implements Action {
    @Override
    public void execute(Chat chat) {
        chat.setState(ChatState.MESSAGE);
    }
}
