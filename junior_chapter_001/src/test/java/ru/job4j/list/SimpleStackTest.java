package ru.job4j.list;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
/**
 *
 * @Test
 * @athor Oleg Buryachenko (mailto: ovburyachenko@yandex.ru)
 * @since 0.1
 * @version $Id$
 */
public class SimpleStackTest {

    @Test(expected = NullPointerException.class)
    public void whenPushThreeElementsThenResultStackData() {
        SimpleStack<Integer> simpleStack = new SimpleStack<>();
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);
        assertThat(simpleStack.poll(), is(3));
        simpleStack.push(4);
        assertThat(simpleStack.poll(), is(4));
        assertThat(simpleStack.poll(), is(2));
        assertThat(simpleStack.poll(), is(1));
        simpleStack.poll();
    }

}