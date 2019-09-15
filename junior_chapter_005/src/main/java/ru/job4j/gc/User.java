package ru.job4j.gc;
public class User {
    private final String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void finalize() {
        System.out.println(this.name + " close! " + System.currentTimeMillis());
    }
}
