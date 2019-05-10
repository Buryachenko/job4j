package ru.job4j.io.chat;

public class SendMessage implements Action {
    @Override
    public void execute(Chat chat) {
        if (chat.getState() == ChatState.MESSAGE) {
            String msg = chat.answerProgram();
            chat.toWriteLog("Program", msg);
            System.out.println("Program:");
            System.out.println("    " + msg);
        }
    }
}
