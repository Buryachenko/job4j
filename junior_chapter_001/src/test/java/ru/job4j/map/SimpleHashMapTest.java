package ru.job4j.map;

import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 *
 * @Test
 * @athor Oleg Buryachenko (mailto: ovburyachenko@yandex.ru)
 * @since 0.1
 * @version $Id$
 */
public class SimpleHashMapTest {

    @Test
    public void whenHashMapAddElementWidthCollision() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        assertThat(map.insert(20, "First"), is(true));
        assertThat(map.insert(36, "Second"), is(false));
        assertThat(map.insert(52, "Third"), is(false));
    }

    @Test
    public void whenHashMapGetAndDeleteElement() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        assertThat(map.insert(20, "First"), is(true));
        assertThat(map.insert(21, "Second"), is(true));
        assertThat(map.get(20), is("First"));
        assertThat(map.get(21), is("Second"));
        assertThat(map.delete(20), is(true));
        assertNull(map.get(20));
        assertThat(map.delete(21), is(true));
        assertNull(map.get(21));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenHashMapUsingIterator() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        assertThat(map.insert(20, "First"), is(true));
        assertThat(map.insert(21, "Second"), is(true));
        assertThat(map.insert(22, "Third"), is(true));
        Iterator<String> it = map.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("First"));
        assertThat(it.next(), is("Second"));
        assertThat(it.next(), is("Third"));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    @Test
    public void whenHashMapChangeCapacity() {
        int defaultSize = 16;
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        for (int i = 0; i < defaultSize * 2; i++) {
            assertThat(map.insert(i, Integer.toString(i)), is(true));
        }
        for (int i = 0; i < defaultSize * 2; i++) {
            assertThat(map.get(i), is(Integer.toString(i)));
        }
    }
}