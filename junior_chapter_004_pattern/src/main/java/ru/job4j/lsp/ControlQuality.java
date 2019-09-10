package ru.job4j.lsp;

import java.util.Map;
import java.util.stream.Collectors;

public class ControlQuality {

    private Map<String, IStorage> map;

    public ControlQuality(Map<String, IStorage> map) {
        this.map = map;
    }

    public boolean put(String key, Food food) {
        return this.map.values().stream().anyMatch(storage -> storage.add(key, food));
    }

    public IStorage get(String key) {
        return this.map.get(key);
    }

    public void resort() {
        Map<String, Food> foods = this.map.values().stream().map(IStorage::foods)
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        clearFoods();
        foods.forEach(this::put);
    }
    public void clearFoods() {
        this.map.values().forEach(storage -> storage.foods().clear());
    }
}
