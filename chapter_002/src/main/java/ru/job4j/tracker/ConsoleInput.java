package ru.job4j.tracker;
import java.util.*;
/**
 *  Class Класс используется для ввода пользовательских данных из консоли.
 *  @author Buryachenko
 *  @since 10.01.2019
 *  @version 1
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}