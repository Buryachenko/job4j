package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

/**
 *  Class Класс точка входа в программу.
 *  @author Buryachenko
 *  @since 10.01.2019
 *  @version 1
 */
public class StartUI {
    private boolean exit = true;
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String ID = "4";
    private static final String NAME = "5";
    private static final String EXIT = "6";
    private final Input input;
    private final ITracker tracker;
    private final Consumer<String> output;

    public StartUI(Input input, ITracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, this.output);
        menu.fillActions(this);
        int[] range = new int[menu.getActionsLength()];
        for (int i = 0; i < range.length; i++) {
            range[i] = i;
        }
        do {
            menu.show();
            int key = input.ask("Введите пункт меню : ", range);
            menu.select(key);

        } while (this.exit);
    }

    public void stop() {
        this.exit = false;
    }

    private void createItem() {
        this.output.accept("--------- Добавление новой заявки ---------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        this.output.accept("--------- Новая заявка с getId :" + item.getId() + "---------");
    }
    private void showItems() {
        this.output.accept("--------- Список заявок ---------");
        if (tracker.getPosition() > 0) {
            for (int i = 0; i < tracker.getPosition(); i++) {
                String id = tracker.findAll().get(i).getId();
                String name = tracker.findAll().get(i).getName();
                String desc = tracker.findAll().get(i).getDesc();
                this.output.accept(i + ". " + " NAME = " + name + "; DESC = " + desc + "; ID = " + id);
            }
        } else {
            this.output.accept("Нет заявок.");
        }
        this.output.accept("---------------------------------");
    }
    private void editItem() {
        this.output.accept("--------- Изменение заявки ---------");
        String id = this.input.ask("Введите индефикатор заявки :");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки");
        Item item = new Item(name, desc);
        if (this.tracker.replace(id, item)) {
            this.output.accept("Заявка изменена.");
        } else {
            this.output.accept("Заявка не найдена.");
        }
        this.output.accept("-----------------------------------");
    }
    private void deleteItem() {
        this.output.accept("--------- Удаление заявки ---------");
        String id = this.input.ask("Введите индефикатор заявки :");
        if (tracker.delete(id)) {
            this.output.accept("Заявка успешно удалена.");
        } else {
            this.output.accept("Заявка не найдена.");
        }
        this.output.accept("-----------------------------------");
    }
    private void findItemById() {
        this.output.accept("-------------------------------");
        String id = this.input.ask("Введите индефикатор заявки :");
        if (tracker.findById(id) != null) {
            String name = tracker.findById(id).getName();
            String desc = tracker.findById(id).getDesc();
            this.output.accept("Name = " + name + "; Desc = " + desc);
        } else {
            this.output.accept("Заявка не найдена.");
        }
        this.output.accept("-------------------------------");
    }
    private void findItemByName() {
        this.output.accept("-----------------------------------");
        String name = this.input.ask("Введите имя заявки :");
        if (!tracker.findByName(name).isEmpty()) {
            for (Item item : tracker.findByName(name)) {
                this.output.accept("ID = " + item.getId() + "; Desc = " + item.getDesc());
            }
        } else {
            this.output.accept("Заявка не найдена.");
        }
        this.output.accept("-----------------------------------");
    }
    private void showMenu() {
        this.output.accept("Меню.");
        this.output.accept("0. Add new Item");
        this.output.accept("1. Show all items");
        this.output.accept("2. Edit item");
        this.output.accept("3. Delete item");
        this.output.accept("4. Find item by Id");
        this.output.accept("5. Find items by name");
        this.output.accept("6. Exit Program");
        this.output.accept("Select:");
    }
    public static void main(String[] args) {
        new StartUI(
                new ValidateInput(
                        new ConsoleInput()
                ),
                new Tracker(),
                System.out :: println
        ).init();
    }
}
