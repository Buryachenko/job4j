package ru.job4j.tracker;
import java.util.ArrayList;
import java.util.List;
/**
 *  Class Класс используется для отображения меню в консоли.
 *  @author Buryachenko
 *  @since 15.01.2019
 *  @version 1
 */
public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    
    public int getActionsLength() {
        return this.actions.size();
    }
    
    public void fillActions(StartUI ui) {
        this.actions.add(new AddItem(0, "0. Add new Item"));
        this.actions.add(new ShowItems(1, "1. Show all items"));
        this.actions.add(new UpdateItem(2, "2. Edit item"));
        this.actions.add(new DeleteItem(3, "3. Delete item"));
        this.actions.add(new FindItemById(4, "4. Find item by Id"));
        this.actions.add(new FindItemsByName(5, "5. Find items by name"));
        this.actions.add(new ExitProgram(6, "6. Exit Program", ui));
    }
    
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }
    
    public void show() {
        System.out.println("Меню.");
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
}