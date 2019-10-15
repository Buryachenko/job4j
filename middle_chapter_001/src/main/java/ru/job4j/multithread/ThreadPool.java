package ru.job4j.multithread;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Class ThreadPool
 * @athor Buryachenko
 * @since 14.10.19
 * @version 1
 */
public class ThreadPool {
    /**
     * @param pool of threads with a size equal to the number of processor cores
     * @param tasks is the blocking queue
     */
    private final List<Thread> pool = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>(1000);
    private boolean isShutdown = false;
    public ThreadPool() {
        generatePool(Runtime.getRuntime().availableProcessors());
    }

    public boolean work(Runnable job) throws InterruptedException {
        if (!this.isShutdown) {
            this.tasks.offer(job);
            return true;
        }
        return false;
    }

    public void shutdown() {
        System.out.println("Shutdown: ");
        this.isShutdown = true;
        while (this.tasks.size() != 0) {
            Thread.yield();
        }
        this.pool.forEach(Thread::interrupt);
    }

    private void generatePool(int size) {
        IntStream.range(0, size).mapToObj(i -> new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    Runnable task = tasks.poll();
                    if (task != null) {
                        task.run();
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Interrupt " + Thread.currentThread().getName());
            }
        })).forEach(thread -> {
            thread.start();
            this.pool.add(thread);
        });
    }
}
