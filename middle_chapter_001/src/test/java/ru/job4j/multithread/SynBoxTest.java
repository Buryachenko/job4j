package ru.job4j.multithread;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SynBoxTest {

    private class ThreadSynBox extends Thread {
        private final SynBox<Integer> synBox;
        private final int value;
        private ThreadSynBox(final SynBox<Integer> synBox, final int value) {
            this.synBox = synBox;
            this.value = value;
        }
        @Override
        public void run() {
            this.synBox.add(this.value);
        }
    }

    @Test
    public void whenExecute2ThreadThen2() throws InterruptedException {
        final SynBox<Integer> synBox = new SynBox<>();
        Thread first = new SynBoxTest.ThreadSynBox(synBox, 1);
        Thread second = new SynBoxTest.ThreadSynBox(synBox, 2);
        first.start();
        second.start();
        first.join();
        second.join();
        assertThat(synBox.get(1), is(2));
    }
}