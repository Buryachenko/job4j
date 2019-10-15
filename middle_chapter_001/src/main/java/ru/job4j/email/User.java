package ru.job4j.email;

/**
 * @Class User
 * @athor Buryachenko
 * @since 15.10.19
 * @version 1
 */
public class User {
    private final String name;
    private final String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }
}
