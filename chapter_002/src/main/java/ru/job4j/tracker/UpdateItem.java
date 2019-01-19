package ru.job4j.tracker;
/**
 *  Class Класс для изменения заявки.
 *  @author Buryachenko
 *  @since 15.01.2019
 *  @version 1
 */
public class UpdateItem implements UserAction {
    private int key = 2;
    private String info = "Edit item.";
    
    public UpdateItem(int i, String info) {
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
        System.out.println("--------- Изменение заявки ---------");
        String id = input.ask("Введите индефикатор заявки :");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки");
        Item item = new Item(name, desc);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка изменена.");
        } else {
            System.out.println("Заявка не найдена.");
        }
        System.out.println("-----------------------------------");
    }
}
