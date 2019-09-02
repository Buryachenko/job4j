package ru.job4j.lsp;

import java.util.function.Predicate;

public class Shop extends Storage {
    public Shop() {
        super(valid -> (valid >= 25.0f && valid < 100.0f));
    }

    public Shop(Predicate<Long> predicate) {
        super(predicate);
    }

    @Override
    public boolean add(String key, Food food) {
        Long valid = food.valid();
        if (this.predicate.test(valid)) {
            if (valid > 75.0f) {
                food.changeDisscount(50);
            }
            return food.equals(this.map.put(key, food));
        }
        return  false;
    }
}
