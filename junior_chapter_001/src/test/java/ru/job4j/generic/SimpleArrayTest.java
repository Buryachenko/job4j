package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *
 * @Test
 * @athor Oleg Buryachenko (mailto: ovburyachenko@yandex.ru)
 * @since 0.1
 * @version $Id$
 */
public class SimpleArrayTest {
    private SimpleArray<String> simpleArray;
    private final int size = 10;
    @Before
    public void init() {
        simpleArray = new SimpleArray<>(size);
    }

    @Test
    public void whenSimpleArrayShouldAddElement() {
        simpleArray.add("test1");
        assertThat(simpleArray.get(0), is("test1"));
    }

    @Test
    public void whenSimpleArrayShouldSetElement() {
        simpleArray.add("test1");
        simpleArray.set(0, "test2");
        assertThat(simpleArray.get(0), is("test2"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenSimpleArrayShouldRemoveElement() {
        simpleArray.add("test1");
        simpleArray.add("test2");
        simpleArray.add("test3");
        simpleArray.remove(0);
        assertThat(simpleArray.get(0), is("test2"));
        simpleArray.remove(0);
        assertThat(simpleArray.get(0), is("test3"));
        simpleArray.remove(0);
        simpleArray.get(0);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenSimpleArrayMustHaveIterator() {
        Iterator<String> it = simpleArray.iterator();
        for (int i = 0; i < size; i++) {
            simpleArray.add(Integer.toString(i));
        }
        for (int i = 0; i < size; i++) {
            assertThat(simpleArray.get(i), is(it.next()));
        }
        assertThat(it.hasNext(), is(false));
        it.next();
    }
}