package ru.job4j.tracker;
/**
 *  Class Класс для поиска заявки по идентификатору Id.
 *  @author Buryachenko
 *  @since 15.01.2019
 *  @version 1
 */
public class FindItemById implements UserAction {

    private int key = 4;
    private String info = "Find item by Id";
    
    FindItemById(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return key;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("-------------------------------");
        String id = input.ask("Введите индефикатор заявки :");
        if (tracker.findById(id) != null) {
            String name = tracker.findById(id).getName();
            String desc = tracker.findById(id).getDesc();
            System.out.println("Name = " + name + "; Desc = " + desc);
        } else {
            System.out.println("Заявка не найдена.");
        }
        System.out.println("-------------------------------");
    }

    @Override
    public String info() {
        return info;
    }
    
}
