package ru.job4j.multithread;


public class Tracker implements Runnable {
    private final Item item;
    private int id;
    public Tracker(Item item, int id) {
        this.item = item;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.item.setId(this.id);
    }
}
