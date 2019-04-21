package ru.job4j.io;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileReader;
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
    String source = "C:\\projects\\job4j\\source.txt";
    String target = "C:\\projects\\job4j\\target.txt";

    @Test
    public void whenWriteTwoStrOfTarget() {
        Analizy analizy = new Analizy();
        analizy.unavailable(source, target);
        try (BufferedReader read = new BufferedReader(new FileReader(target))) {
            Iterator<String> reader = read.lines().iterator();
            assertThat(reader.next(), is("10:57:01;10:59:01"));
            assertThat(reader.next(), is("11:01:02;11:02:02"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}