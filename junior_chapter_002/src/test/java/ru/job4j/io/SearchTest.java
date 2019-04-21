package ru.job4j.io;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

import static org.junit.Assert.*;

public class SearchTest {
    @Test
    public void whenReader() {
        List<String> exts = Arrays.asList(".txt", ".xml");
        Search search = new Search();
        List<File> files = search.files("ExampleForSearchFiles", exts);
        Iterator<File> it = files.iterator();
        assertThat(it.next().getName(), is("example.txt"));
        assertThat(it.next().getName(), is("example.xml"));
    }
}