package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
/**
 *
 * @Test
 * @athor Oleg Buryachenko (mailto: ovburyachenko@yandex.ru)
 * @since 0.1
 * @version $Id$
 */
public class BoxNodeTest {
    BoxNode<Integer> boxNode;
    @Before
    public void init() {
        boxNode = new BoxNode<>();
        boxNode.add(1);
        boxNode.add(2);
        boxNode.add(3);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(boxNode.get(1), is(2));
        boxNode.get(5);
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCreateIteratorAddOneElementThenUseNext() {
        Iterator<Integer> it1 = boxNode.iterator();
        assertThat(it1.next(), is(3));
        assertThat(it1.next(), is(2));
        boxNode.add(4);
        Iterator<Integer> it2 = boxNode.iterator();
        assertThat(it2.next(), is(4));
        assertThat(it2.next(), is(3));
        it1.next();
    }
}