package ru.job4j.multithread;

/**
 * Class User
 * @author Buryachenko
 * @version 1
 * @since 07.10.2019
 */
public class User {
    private final int id;
    private  int amount;

    /**
     * @param id is the user identifier
     * @param amount is user funds
     */
    public User(final int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    protected int getId() {
       return this.id;
    }

    public int amount() {
        return this.amount;
    }
    protected void loss(int amount) {
        this.amount -= amount;
    }
    protected void profit(int amount) {
        this.amount += amount;
    }
}
