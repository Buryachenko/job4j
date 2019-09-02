package ru.job4j.lsp;
import java.util.HashMap;
import java.util.Map;

public interface IStorage {
    boolean add(String key, Food food);
    Map<String, Food> foods();
}