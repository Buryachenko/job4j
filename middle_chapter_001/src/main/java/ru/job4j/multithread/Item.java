package ru.job4j.multithread;

public class Item {
    private int id;
    public Item(int id) {
        this.id = id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }
    @Override
    public String toString() {
        return Integer.toString(this.id);
    }
}
