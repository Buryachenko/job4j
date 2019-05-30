package ru.job4j.sqlite;

import static org.junit.Assert.*;
import  static org.hamcrest.core.Is.is;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class StoreSQLTest {
    int size = 10;
    List<Entry> expected = new ArrayList<>();

    @Before
    public void generate() {
        for(int i = 0; i < size; i++) {
            expected.add(new Entry(i));
        }
    }

    @Test
    public void whenGenerateValueToInsertTableAndLoadInListEntry() {
        StoreSQL storeSQL = new StoreSQL(new Config());
        storeSQL.generate(size);
        List<Entry> listEntry = storeSQL.load();
        assertThat(expected, is(listEntry));
    }
}