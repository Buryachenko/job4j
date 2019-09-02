package ru.job4j.lsp;

import java.util.function.Predicate;

public class Warehouse extends Storage {

    public Warehouse() {
        super(valid -> (valid < 25.0f));
    }

    public Warehouse(Predicate<Long> predicate) {
        super(predicate);
    }
}
