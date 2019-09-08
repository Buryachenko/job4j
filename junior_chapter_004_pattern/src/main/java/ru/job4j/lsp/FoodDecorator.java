package ru.job4j.lsp;

import java.text.ParseException;
import java.util.Date;

public class FoodDecorator extends Food {
    private boolean canReproduct = false;

    public FoodDecorator(String name, Date expaireDate, Date createDate, double price, double disscount, boolean canReproduct) throws ParseException {
        super(name, expaireDate, createDate, price, disscount);
        this.canReproduct = canReproduct;
    }

    public boolean isCanReproduct() {
        return this.canReproduct;
    }
}
