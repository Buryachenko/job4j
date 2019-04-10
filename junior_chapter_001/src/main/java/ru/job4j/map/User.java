package ru.job4j.map;

import java.util.Calendar;
import java.util.Objects;

/**
 *
 * Class Класс User
 * @athor Oleg Buryachenko
 * @since 10.04.19
 * @version 1
 */
public class User {
    private String name;
    private int children;
    private Calendar birthday;

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }
}
