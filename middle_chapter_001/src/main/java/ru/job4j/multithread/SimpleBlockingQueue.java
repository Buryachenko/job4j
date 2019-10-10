package ru.job4j.multithread;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;
/**
 * Class SimpleBlockingQueue
 * @author Buryachenko
 * @version 1
 * @since 10.10.2019
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {
    private final int size;
    @GuardedBy("this")
    private final Queue<T> queue = new LinkedList<>();

    /**
     *
     * @param size is limit queue
     */
    public SimpleBlockingQueue(int size) {
        this.size = size;
    }

    public void offer(T value) throws InterruptedException {
        synchronized (this.queue) {
            if (this.queue.size() < this.size) {
                this.queue.offer(value);
                this.queue.notify();
            } else {
                System.out.println("offer wait");
                this.queue.wait();
            }
        }
    }

    public T poll() throws InterruptedException {
        synchronized (this.queue) {
            if (!this.queue.isEmpty()) {
                this.queue.notify();
                return this.queue.poll();
            } else {
                System.out.println("pool wait");
                this.queue.wait();
            }
        }
        return null;
    }

    public synchronized int size() {
        return this.queue.size();
    }
}
