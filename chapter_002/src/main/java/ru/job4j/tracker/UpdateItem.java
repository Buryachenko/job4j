package ru.job4j.tracker;
/**
 *  Class Класс для изменения заявки.
 *  @author Buryachenko
 *  @since 15.01.2019
 *  @version 1
 */
public class UpdateItem extends BaseAction {

    public UpdateItem(int key, String info) {
		super(key, info);
    }

    @Override
    public void execute(Input input, ITracker tracker) {
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
