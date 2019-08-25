package ru.job4j.lsp;
import java.util.HashMap;
import java.util.Map;

public abstract class Storage {
    private Map<String, Food> map = new HashMap<>();
    public void add(String key, Food food) {
        map.put(key, food);
    }
    public Map<String, Food> foods() {
        return this.map;
    }
}