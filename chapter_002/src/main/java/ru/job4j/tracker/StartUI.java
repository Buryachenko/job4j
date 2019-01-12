package ru.job4j.tracker;
/**
 *  Class Класс точка входа в программу.
 *  @author Buryachenko
 *  @since 10.01.2019
 *  @version 1
 */
public class StartUI {
    private static final String ADD = "0";
    private static final String EXIT = "6";
    private final Input input;
    private final Tracker tracker;
    
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    public void init() {
        boolean exit = false;
        while(!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if(ADD.equals(answer)) {
                this.createItem();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }
    private void createItem() {
        System.out.println("--------- Добавление новой заявки ---------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("--------- Новая заявка с getId :" + item.getId() + "---------");
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
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
