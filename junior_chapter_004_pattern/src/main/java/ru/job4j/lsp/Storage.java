package ru.job4j.lsp;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class Storage implements IStorage {
    protected Predicate<Long> predicate;
    protected Map<String, Food> map = new HashMap<>();

    public Storage(Predicate<Long> predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean add(String key, Food food) {
        if (predicate.test(food.valid())) {
            return food.equals(map.put(key, food));
        }
        return  false;
    }

    @Override
    public Map<String, Food> foods() {
        return this.map;
    }
}
