package ru.job4j.isp;

import java.util.*;
/**
 *  Class Класс поддерживает структуру меню.
 *  @author Buryachenko
 *  @since 26.08.2019
 *  @version 1
 */
public class Menu {
    private String name;
    Map<String, ItemMenu> items = new LinkedHashMap<>();

    public Menu () {
        this.name = "Меню:";
    }

    public void show() {
        System.out.println(this.name);
        Deque<Iterator<ItemMenu>> deque = new LinkedList<>();
        Iterator<ItemMenu> root = this.items.values().iterator();
        while (root.hasNext()) {
            ItemMenu item = root.next();
            Iterator<ItemMenu> source = item.items().values().iterator();
            System.out.println(item.info());
            if(root.hasNext()) {
                deque.offer(root);
            }
            if (source.hasNext()) {
                root = source;
            } else if (!deque.isEmpty()){
                root = deque.pollLast();
            }
        }
    }

    public ItemMenu add(ItemMenu item) {
        this.items.put(item.key(), item);
        return this.items.get(item.key());
    }

    public ItemMenu get(String key) {
        return this.items.get(key);
    }
}
