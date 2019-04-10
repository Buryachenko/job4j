package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static  org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 *
 * @Test
 * @athor Oleg Buryachenko (mailto: ovburyachenko@yandex.ru)
 * @since 0.1
 * @version $Id$
 */
public class SimpleSetTest {
    SimpleSet<Integer> simpleSet;
    @Before
    public void init() {
        simpleSet = new SimpleSet<>(10);
        simpleSet.add(1);
        simpleSet.add(1);
        simpleSet.add(2);
        simpleSet.add(2);
        simpleSet.add(3);
        simpleSet.add(3);
    }
    @Test(expected = NoSuchElementException.class)
    public void whenAddElementWithoutDuplicate() {
        Iterator<Integer> it = simpleSet.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        it.next();
    }
}