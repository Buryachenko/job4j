package ru.job4j.lsp;
import java.util.Map;

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
}
