package ru.job4j.nonblocking;

/**
 * Class Base
 * @athor Buryachenko
 * @since 13.10.19
 * @version 1
 */
public class Base {
    private final int id;
    private int version;
    private String data;

    public Base(int id, String data) {
        this.id = id;
        this.data = data;
    }

    public int id() {
        return this.id;
    }

    public int version() {
        return this.version;
    }

    public void changeVersion() {
        this.version++;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

}
