package ru.job4j.tracker;
/**
 *  Class Класс для удаления заявки.
 *  @author Buryachenko
 *  @since 15.01.2019
 *  @version 1
 */
public class DeleteItem extends BaseAction {
    
    DeleteItem(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(Input input, ITracker tracker) {
        System.out.println("--------- Удаление заявки ---------");
        String id = input.ask("Введите индефикатор заявки :");
        if (tracker.delete(id)) {
            System.out.println("Заявка успешно удалена.");
        } else {
            System.out.println("Заявка не найдена.");
        }
        System.out.println("-----------------------------------");
    } 
}
