package ru.job4j.tracker;
/**
 *  Class Класс используется для размещения тестов.
 *  @author Buryachenko
 *  @since 10.01.2019
 *  @version 1
 */
public class StartUITest {
    public static void main(String[] args) {
        Input input = new StubInput(new String[] {"Create stub task"});
        new StartUI(input, new Tracker()).init();
    }
}
