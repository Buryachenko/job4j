package ru.job4j.tracker;
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
    public void execute(Input input, Tracker tracker) {
        System.out.println("-----------------------------------");
        String name = input.ask("Введите имя заявки :");
        Item[] items = tracker.findByName(name);
        if (items != null) {
            for (int i = 0; i < items.length; i++) {
                System.out.println("ID = " + items[i].getId() + "; Desc = " + items[i].getDesc());
            }
        } else {
            System.out.println("Заявка не найдена.");
        }
        System.out.println("-----------------------------------");
    }
}
