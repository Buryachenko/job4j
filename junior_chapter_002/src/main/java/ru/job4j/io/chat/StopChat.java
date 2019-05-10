package ru.job4j.io.chat;

public class StopChat implements Action {
    @Override
    public void execute(Chat chat) {
        chat.setState(ChatState.STOP);
    }
}
