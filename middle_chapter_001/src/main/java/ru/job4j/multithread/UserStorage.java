package ru.job4j.multithread;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import java.util.*;
/**
 * Class UserStorage is a union of User objects.
 * @author Buryachenko
 * @version 1
 * @since 07.10.2019
 */
@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    private final Map<Integer, User> storage = new HashMap<>();

    public synchronized boolean add(User user) {
       return user.equals(this.storage.put(user.getId(), user));
    }
    public synchronized boolean update(User user) {
        return user.equals(this.storage.replace(user.getId(), user));
    }
    public synchronized boolean delete(User user) {
        return user.equals(this.storage.remove(user));
    }
    public synchronized void transfer(int fromId, int toId, int amount) {
        this.storage.get(fromId).loss(amount);
        this.storage.get(toId).profit(amount);
    }
    public synchronized User get(int id) {
        return this.storage.get(id);
    }
}
