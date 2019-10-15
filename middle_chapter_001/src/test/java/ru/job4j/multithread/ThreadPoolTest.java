package ru.job4j.multithread;
import org.junit.Test;

public class ThreadPoolTest {
    @Test
    public void whenRunWorkOfThreeParallelTask() throws InterruptedException {
        ThreadPool pool = new ThreadPool();
        pool.work(() -> System.out.println("Execute task №1 " + Thread.currentThread().getName()));
        pool.work(() -> System.out.println("Execute task №2 " + Thread.currentThread().getName()));
        pool.work(() -> System.out.println("Execute task №3 " + Thread.currentThread().getName()));
        Thread.sleep(1000);
        pool.shutdown();
    }
}