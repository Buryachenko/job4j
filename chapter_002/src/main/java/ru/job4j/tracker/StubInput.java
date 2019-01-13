package ru.job4j.tracker;
/**
 *  Class Класс для эмуляции поведения пользователя.
 *  @author Buryachenko
 *  @since 10.01.2019
 *  @version 1
 */
public class StubInput implements Input {
    private String[] answers;
    private int position = 0;
    public StubInput(String[] answers) {
        this.answers = answers;
    }
    public String ask(String question) {
        //return answers[position++];
        return answers[0];
    }
}
