package ru.job4j.lsp;

import java.util.function.Predicate;

public class Reproduct extends Trash {
    public Reproduct() {

    }
    public Reproduct(Predicate<Long> predicate) {
        super(predicate);
    }
}
