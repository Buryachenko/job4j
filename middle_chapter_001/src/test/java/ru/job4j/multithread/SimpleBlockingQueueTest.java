package ru.job4j.multithread;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.core.Is.*;

public class SimpleBlockingQueueTest {
    /**
     * Class ThreadOffer this is a Producer
     */
    private class ThreadOffer extends Thread {
        private final SimpleBlockingQueue<String> queue;

        private ThreadOffer(final SimpleBlockingQueue<String> queue) {
            this.queue = queue;
        }
        @Override
        public void run() {
            try {
                int count = 0;
                while (!Thread.currentThread().isInterrupted()) {
                    this.queue.offer(Integer.toString(count));
                    System.out.println(String.format("offer %s %s", count, Thread.currentThread().getName()));
                    count++;
                }
            } catch (InterruptedException e) {
                System.err.println(String.format("finish offer %s", Thread.currentThread().getName()));
            }
        }
    }

    /**
     * Class ThreadPool this is a Consumer
     */
    private class ThreadPool extends Thread {
        private final SimpleBlockingQueue<String> queue;
        public ThreadPool(final SimpleBlockingQueue<String> queue) {
            this.queue = queue;
        }
        @Override
        public void run() {
            try {
                int count = 0;
                while (!Thread.currentThread().isInterrupted()) {
                    this.queue.poll();
                    System.out.println(String.format("poll %s %s", count, Thread.currentThread().getName()));
                    count++;
                }
            } catch (InterruptedException e) {
                System.err.println(String.format("finish poll %s", Thread.currentThread().getName()));
            }
        }
    }

    @Test
    public void whenMultiThreadAccessToQueue() throws InterruptedException {
        final SimpleBlockingQueue<String> queue = new SimpleBlockingQueue<>(5);
        ThreadPool threadPool0 = new ThreadPool(queue);
        ThreadPool threadPool1 = new ThreadPool(queue);
        ThreadOffer threadOffer0 = new ThreadOffer(queue);
        ThreadOffer threadOffer1 = new ThreadOffer(queue);

        threadOffer0.start();
        threadOffer1.start();

        threadOffer0.join(10);
        threadOffer1.join(10);

        threadPool0.start();
        threadPool1.start();

        threadOffer0.interrupt();
        threadOffer1.interrupt();

        threadPool0.join(50);
        threadPool1.join(50);

        threadPool0.interrupt();
        threadPool1.interrupt();

        assertThat(queue.size(), is(0));
    }
}