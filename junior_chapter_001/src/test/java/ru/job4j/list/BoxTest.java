package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BoxTest {
    Box<Integer> box;
    @Before
    public void init() {
        box = new Box<>();
        box.add(1);
        box.add(2);
        box.add(3);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(box.get(1), is(2));
        box.get(5);
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCreateIteratorAddOneElementThenUseNext() {
        Iterator<Integer> it1 = box.iterator();
        assertThat(it1.next(), is(1));
        assertThat(it1.next(), is(2));
        box.add(4);
        Iterator<Integer> it2 = box.iterator();
        assertThat(it1.next(), is(1));
        assertThat(it1.next(), is(2));
        it1.next();
    }
}