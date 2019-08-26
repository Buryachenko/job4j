package ru.job4j.isp;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
/**
 *  Class Класс пункт меню.
 *  @author Buryachenko
 *  @since 26.08.2019
 *  @version 1
 */
public class ItemMenu  {
    private final String name;
    private final String key;
    private Map<String, ItemMenu> items = new LinkedHashMap<>();

    public ItemMenu(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public ItemMenu add(ItemMenu item) {
        return this.items.put(item.key, item);
    }

    public ItemMenu get(String key) {
        return this.items.get(key);
    }

    public Map<String, ItemMenu> items() {
        return this.items;
    }

    public String key() {
        return this.key;
    }

    public String info() {
        return this.name;
    }

    public void execute(Object o1, Consumer consumer) {
        if (o1 != null) {
            consumer.accept(o1);
        }
    }
}
