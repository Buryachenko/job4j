package ru.job4j.tracker;
/**
 *  Class Класс для удаления заявки.
 *  @author Buryachenko
 *  @since 15.01.2019
 *  @version 1
 */
public class ExitProgram implements UserAction {
    private StartUI ui;
    private int key = 6;
    private String info = "Exit Program";

    public ExitProgram(int key, String info, StartUI ui) {

        this.key = key;
        this.info = info;
        this.ui = ui;
    }
    
    @Override
    public int key() {
        return key;
    }

    @Override
    public void execute(Input input, ITracker tracker) {
        System.out.println("------------ Exit program --------------");
        this.ui.stop();
    }

    @Override
    public String info() {
        return info;
    }
}
