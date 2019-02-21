package ru.job4j.sort;
import java.util.*;

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

    public List<User> sortNameLength(List<User> users) {
        users.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return Integer.compare(o1.getName().length(), o2.getName().length());
                    }
                }
        );
        return users;
    }

    public List<User> sortByAllFields(List<User> users) {
        users.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        int resAge = Integer.compare(o1.getAge(), o2.getAge());
                        int resName = o1.getName().compareTo(o2.getName());
                        return resName == 0 ? resAge : resName;
                    }
                }
        );
        return users;
    }
}