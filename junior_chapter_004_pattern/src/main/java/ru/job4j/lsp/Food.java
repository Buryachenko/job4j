package ru.job4j.lsp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.lang.String;

public class Food {
    private final String name;
    private final Date expaireDate;
    private final Date createDate;
    private final double price;
    private final DateFormat format = new SimpleDateFormat("dd.MM.yyyy",Locale.ENGLISH);
    private double disscount;

    public Food(String name, Date expaireDate, Date createDate, double price, double disscount) throws ParseException {
        this.name = name;
        this.expaireDate = expaireDate;
        this.createDate = createDate;
        this.price = price;
        this.disscount = disscount;
    }

    public String name() {
        return this.name;
    }

    public Date expaireDate() {
        return this.expaireDate;
    }

    public Date createDate() {
        return this.createDate;
    }

    public double price() {
        return price*(1 - disscount/100);
    }

    public double disscount() {
        return disscount;
    }

    public void changeDisscount(double disscount) {
        this.disscount = disscount;
    }

    public long valid() {
        long create = this.createDate().getTime();
        return  (System.currentTimeMillis() - create) * 100 / (this.expaireDate().getTime() - create);
    }
}
