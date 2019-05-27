package ru.job4j.tracker;
/**
 *  Class Класс для поиска заявки по идентификатору Id.
 *  @author Buryachenko
 *  @since 15.01.2019
 *  @version 1
 */
public class FindItemById extends BaseAction {
    
    FindItemById(int key, String info) {
		super(key, info);
    }

    @Override
    public void execute(Input input, ITracker tracker) {
        System.out.println("-------------------------------");
        String id = input.ask("Введите индефикатор заявки :");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("Name = " + item.getName() + "; Desc = " + item.getDesc());
        } else {
            System.out.println("Заявка не найдена.");
        }
        System.out.println("-------------------------------");
    } 
}
