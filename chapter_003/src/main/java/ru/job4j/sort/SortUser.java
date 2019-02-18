package ru.job4j.sort;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
/**
 *
 * Class Класс сортировки User
 * @athor Buryachenko
 * @since 18.02.19
 * @version 1
 */
public class SortUser {

    public Set<User> sort(List<User> users) {
        return  new TreeSet<>(users);
    }
}