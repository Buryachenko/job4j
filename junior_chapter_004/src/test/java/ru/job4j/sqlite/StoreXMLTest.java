package ru.job4j.sqlite;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StoreXMLTest {

    @Test
    public void whenSaveListEntryToFileXML() throws Exception {
        StoreSQL storeSQL = new StoreSQL(new Config());
        storeSQL.generate(10);
        List<Entry> listEntry = storeSQL.load();
        StoreXML storeXML = new StoreXML(new File("sqlite/xml/entry.xml"));
        storeXML.save(listEntry);
    }
}