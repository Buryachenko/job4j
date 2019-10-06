package ru.job4j.multithread;

import org.junit.Test;

public class ItemTest {
    @Test
    public void whenMultiThreadWriteIdAndWaitFinish() throws InterruptedException {
        Item item = new Item(0);
        Thread thread1 = new Thread(new Tracker(item, 1));
        Thread thread2 = new Thread(new Tracker(item, 2));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Heap item.id = " + item);
    }

    @Test
    public void whenMultiWriteIdItem() {
        Item item = new Item(0);
        Thread thread1 = new Thread(new Tracker(item, 1));
        Thread thread2 = new Thread(new Tracker(item, 2));
        thread1.start();
        thread2.start();
        System.out.println("Heap item.id = " + item);
    }
}