package ru.job4j.lsp;

import java.util.function.Predicate;

public class Trash extends Storage {
    public Trash() {
        super(valid -> (valid >= 100.0f));
    }

    public Trash(Predicate<Long> predicate) {
        super(predicate);
    }
}
