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
public class SimpleQueueTest {

    @Test(expected = NullPointerException.class)
    public void whenPushThreeElementsThenResultStackData() {
        SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);
        assertThat(simpleQueue.poll(), is(1));
        simpleQueue.push(4);
        assertThat(simpleQueue.poll(), is(2));
        assertThat(simpleQueue.poll(), is(3));
        assertThat(simpleQueue.poll(), is(4));
        simpleQueue.poll();
    }
}