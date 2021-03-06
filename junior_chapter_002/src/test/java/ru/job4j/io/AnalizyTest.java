package ru.job4j.io;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 *
 * @Test
 * @athor Oleg Buryachenko (mailto: ovburyachenko@yandex.ru)
 * @since 0.1
 * @version $Id$
 */
public class AnalizyTest {
    String source = "source.txt";
    String target = "target.txt";
//
    @Test
    public void whenWriteTwoStrOfTarget() throws IOException {
        Analizy analizy = new Analizy();
        analizy.unavailable(source, target);
        try (BufferedReader read = new BufferedReader(new FileReader(target))) {
            Iterator<String> reader = read.lines().iterator();
            assertThat(reader.next(), is("10:57:01;10:59:01"));
            assertThat(reader.next(), is("11:01:02;11:02:02"));
        }
    }

    @Test(expected = FileNotFoundException.class)
    public void whenFileNotFoundException() throws IOException {
        try (BufferedReader read = new BufferedReader(new FileReader("not file"))) {
            read.lines();
        }
    }
}