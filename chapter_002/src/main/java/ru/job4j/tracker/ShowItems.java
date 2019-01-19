package ru.job4j.tracker;
/**
 *  Class Класс для отображения списка заявок.
 *  @author Buryachenko
 *  @since 15.01.2019
 *  @version 1
 */
public class ShowItems implements UserAction {
    private int key = 5;
    private String info = "Show all items";
    
    public ShowItems(int i, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
       return key; 
    }

     @Override
    public String info() {
        return info;
    }
    
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("--------- Список заявок ---------");
        if (tracker.getPosition() > 0) {
            for (int i = 0; i < tracker.getPosition(); i++) {
                String id = tracker.findAll()[i].getId();
                String name = tracker.findAll()[i].getName();
                String desc = tracker.findAll()[i].getDesc();
                System.out.println(i + ". " + " NAME = " + name + "; DESC = " + desc + "; ID = " + id);
            }
        } else {
            System.out.println("Нет заявок.");
        }
        System.out.println("---------------------------------");
    }
    
}
