package ru.job4j.map;

import org.junit.Test;
import static org.hamcrest.core.Is.is;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import static org.junit.Assert.*;
/**
 *
 * @Test
 * @athor Oleg Buryachenko (mailto: ovburyachenko@yandex.ru)
 * @since 0.1
 * @version $Id$
 */
public class SimpleHashMapTest {

    @Test(expected = ConcurrentModificationException.class)
    public void whenAddElementIndexUnknow() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(20, "First");
        map.insert(36, "Second");
        map.insert(52, "Third");
        map.insert(10, "Four");
        map.insert(15, "Five");
        Iterator<String> it = map.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(map.delete(20), is(true));
        assertNull(map.get(20));
        assertThat(map.delete(15), is(true));
        assertNull(map.get(15));
        Iterator<String> it1 = map.iterator();
        assertThat(it1.hasNext(), is(true));
        System.out.println(it1.next());
        assertThat(it1.hasNext(), is(true));
        System.out.println(it1.next());
        assertThat(it1.hasNext(), is(true));
        System.out.println(it1.next());
        assertThat(it1.hasNext(), is(false));
        assertThat(map.delete(36), is(true));
        assertThat(map.delete(10), is(true));
        assertThat(map.delete(52), is(true));
        it1.next();
    }
}