package ru.job4j.tracker;
/**
 *  Class Класс для отображения списка заявок.
 *  @author Buryachenko
 *  @since 15.01.2019
 *  @version 1
 */
public class ShowItems extends BaseAction {

    public ShowItems(int key, String info) {
		super(key, info);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("--------- Список заявок ---------");
        if (tracker.getPosition() > 0) {
            for (int i = 0; i < tracker.getPosition(); i++) {
                String id = tracker.findAll().get(i).getId();
                String name = tracker.findAll().get(i).getName();
                String desc = tracker.findAll().get(i).getDesc();
                System.out.println(i + ". " + " NAME = " + name + "; DESC = " + desc + "; ID = " + id);
            }
        } else {
            System.out.println("Нет заявок.");
        }
        System.out.println("---------------------------------");
    }
}
