package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

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
    private final Tracker tracker;
    
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions(this);
        int[] range = new int[menu.getActionsLentgh()];
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
        System.out.println("--------- Добавление новой заявки ---------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("--------- Новая заявка с getId :" + item.getId() + "---------");
    }
    private void showItems() {
        System.out.println("--------- Список заявок ---------");
        if (tracker.getPosition() > 0) {
            for (int i = 0; i < tracker.getPosition(); i++) {
                String id = tracker.findAll()[i].getId();
                String name = tracker.findAll()[i].getName();
                String desc = tracker.findAll()[i].getDesc();
                System.out.println(i + ". " + " NAME = " + name + "; DESC = " + desc + "; ID = " + id);
            }
        } else {
            System.out.println("Нет заявок.");
        }
        System.out.println("---------------------------------");
    }
    private void editItem() {
        System.out.println("--------- Изменение заявки ---------");
        String id = this.input.ask("Введите индефикатор заявки :");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки");
        Item item = new Item(name, desc);
        if (this.tracker.replace(id, item)) {
            System.out.println("Заявка изменена.");
        } else {
            System.out.println("Заявка не найдена.");
        }
        System.out.println("-----------------------------------");
    }
    private void deleteItem() {
        System.out.println("--------- Удаление заявки ---------");
        String id = this.input.ask("Введите индефикатор заявки :");
        if (tracker.delete(id)) {
            System.out.println("Заявка успешно удалена.");
        } else {
            System.out.println("Заявка не найдена.");
        }
        System.out.println("-----------------------------------");
    }
    private void findItemById() {
        System.out.println("-------------------------------");
        String id = this.input.ask("Введите индефикатор заявки :");
        if (tracker.findById(id) != null) {
            String name = tracker.findById(id).getName();
            String desc = tracker.findById(id).getDesc();
            System.out.println("Name = " + name + "; Desc = " + desc);
        } else {
            System.out.println("Заявка не найдена.");
        }
        System.out.println("-------------------------------");
    }
    private void findItemByName() {
        System.out.println("-----------------------------------");
        String name = this.input.ask("Введите имя заявки :");
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
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("Select:");
    }
    public static void main(String[] args) {
        new StartUI(
                new ValidateInput(
                        new ConsoleInput()
                ),
                new Tracker()
        ).init();
    }
}
