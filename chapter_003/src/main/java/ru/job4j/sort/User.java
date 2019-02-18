package ru.job4j.sort;
/**
 *
 * Class Класс с информацией о пользователе
 * @athor Buryachenko
 * @since 18.02.19
 * @version 1
 */
public class User implements Comparable<User> {
    private String name;
    private int age;
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }

    @Override
    public int compareTo(User o) {
        return Integer.compare(this.age, o.getAge());
    }
}
