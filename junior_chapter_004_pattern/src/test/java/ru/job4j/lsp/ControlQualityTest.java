package ru.job4j.lsp;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import static org.junit.Assert.*;

public class ControlQualityTest {
    private final long shift = 914786214;
    private final long procentGood = 10;
    private final long procentMiddle = 50;
    private final long procentDisscount = 90;
    private final long procentTrash = 110;
    private Date createDate, expGood, expMiddle, expDisscount, expTrash;

    @Before
    public void initPeriodTime() {
        long current = System.currentTimeMillis();
        createDate = new Date(current - shift);
        expGood = new Date(current - shift + shift * 100 / procentGood);
        expMiddle = new Date(current - shift + shift * 100 / procentMiddle);
        expDisscount = new Date(current - shift + shift * 100 / procentDisscount);
        expTrash = new Date(current - shift + shift * 100 / procentTrash);
    }

    @Test
    public void whenFoodPutToStorage() throws ParseException {
        ControlQuality cntr = new ControlQuality(
                Map.of("Warehouse", new Warehouse(),
                        "Shop", new Shop(),
                        "Trash", new Trash()
                )
        );
        cntr.put("Good", new Food("Хлеб",expGood, createDate, 100.0, 0.0));
        cntr.put("Middle", new Food("Молоко", expMiddle, createDate, 150.0, 0.0));
        cntr.put("Disscount", new Food("Творог", expDisscount, createDate, 190.0, 0.0));
        cntr.put("Bad", new Food("Кефир", expTrash, createDate, 300, 0.0));
        assertThat(cntr.get("Warehouse").foods().get("Good").name(), is("Хлеб"));
        assertThat(cntr.get("Shop").foods().get("Middle").name(), is("Молоко"));
        assertThat(cntr.get("Shop").foods().get("Disscount").disscount(), is(50.0));
        assertThat(cntr.get("Trash").foods().get("Bad").name(), is("Кефир"));
    }

    @Test
    public void whenFoodPutToSingleStorage() throws ParseException {
        ControlQuality cntr = new ControlQuality(
                Map.of("Warehouse", new Warehouse())
        );
        cntr.put("Good", new Food("Хлеб",expGood, createDate, 100.0, 0.0));
        cntr.put("Middle", new Food("Молоко", expMiddle, createDate, 150.0, 0.0));
        cntr.put("Disscount", new Food("Творог", expDisscount, createDate, 190.0, 0.0));
        cntr.put("Bad", new Food("Кефир", expTrash, createDate, 300, 0.0));
        assertThat(cntr.get("Warehouse").foods().get("Good").name(), is("Хлеб"));
    }
}