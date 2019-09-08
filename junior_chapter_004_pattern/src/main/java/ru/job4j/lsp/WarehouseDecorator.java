package ru.job4j.lsp;

import java.util.function.Predicate;

public class WarehouseDecorator extends Warehouse {
    public WarehouseDecorator() {}
    public WarehouseDecorator(Predicate<Long> predicate) {
        super(predicate);
    }
    @Override
    public boolean add(String key, Food food) {
        return super.add(key, food);
    }
}
