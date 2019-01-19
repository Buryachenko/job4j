package ru.job4j.tracker;
/**
 *  Class Класс используется для добавления заявки.
 *  @author Buryachenko
 *  @since 15.01.2019
 *  @version 1
 */
public class AddItem implements UserAction {
    private int key = 0;
    private String info = "Add program";

    AddItem(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return key;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("--------- Добавление новой заявки ---------");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки");
        Item item = new Item(name, desc);
        tracker.add(item);
        System.out.println("--------- Новая заявка с getId :" + item.getId() + "---------");
    }

    @Override
    public String info() {
        return info;
    }
}
