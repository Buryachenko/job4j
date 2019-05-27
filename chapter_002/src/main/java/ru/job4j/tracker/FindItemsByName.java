package ru.job4j.tracker;

import java.util.List;

/**
 *  Class Класс для поиска заявки по имени Name.
 *  @author Buryachenko
 *  @since 15.01.2019
 *  @version 1
 */
public class FindItemsByName extends BaseAction {

    FindItemsByName(int key, String info) {
		super(key, info);
    }

    @Override
    public void execute(Input input, ITracker tracker) {
        System.out.println("-----------------------------------");
        String name = input.ask("Введите имя заявки :");
        List<Item> items = tracker.findByName(name);
        if (!items.isEmpty()) {
            for (Item item : items) {
                System.out.println("ID = " + item.getId() + "; Desc = " + item.getDesc());
            }
        } else {
            System.out.println("Заявка не найдена.");
        }
        System.out.println("-----------------------------------");
    }
}
