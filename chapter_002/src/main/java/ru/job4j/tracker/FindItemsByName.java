package ru.job4j.tracker;
/**
 *  Class Класс для поиска заявки по имени Name.
 *  @author Buryachenko
 *  @since 15.01.2019
 *  @version 1
 */
public class FindItemsByName implements UserAction {

    private int key = 5;
    private String info = "Find items by name";
    
    FindItemsByName(int key, String info) {
        this.key = key;
        this.info = info;
    }
    
    @Override
    public int key() {
       return key; 
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("-----------------------------------");
        String name = input.ask("Введите имя заявки :");
        if (tracker.findByName(name) != null) {
            Item[] items = tracker.findByName(name);
            for (int i = 0; i < items.length; i++) {
                System.out.println("ID = " + items[i].getId() + "; Desc = " + items[i].getDesc());
            }
        } else {
            System.out.println("Заявка не найдена.");
        }
        System.out.println("-----------------------------------");
    }

    @Override
    public String info() {
        return info;
    }
    
}
