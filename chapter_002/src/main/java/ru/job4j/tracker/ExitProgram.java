package ru.job4j.tracker;
/**
 *  Class Класс для удаления заявки.
 *  @author Buryachenko
 *  @since 15.01.2019
 *  @version 1
 */
public class ExitProgram implements UserAction {
    private int key = 6;
    private String info = "Exit Program";
    
    public ExitProgram(int key, String info) {
        this.key = key;
        this.info = info; 
    }
    
    @Override
    public int key() {
        return key;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Exit program --------------");
        System.exit(0);
    }

    @Override
    public String info() {
        return info;
    }
}
