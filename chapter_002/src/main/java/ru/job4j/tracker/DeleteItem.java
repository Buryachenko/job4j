package ru.job4j.tracker;
/**
 *  Class Класс для удаления заявки.
 *  @author Buryachenko
 *  @since 15.01.2019
 *  @version 1
 */
public class DeleteItem implements UserAction {
    private int key = 3; 
    String info = "Delete item";
    
         
    DeleteItem(int key, String info) {
        this.key = key;
        this.info = info;
    }
    
    @Override
    public int key() {
        return key;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("--------- Удаление заявки ---------");
        String id = input.ask("Введите индефикатор заявки :");
        if (tracker.delete(id)) {
            System.out.println("Заявка успешно удалена.");
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
