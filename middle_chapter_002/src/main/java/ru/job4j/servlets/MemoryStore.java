package ru.job4j.servlets;
import java.util.*;

public class MemoryStore implements Store {
    private final SortedSet<User> users = Collections.synchronizedSortedSet(new TreeSet<>(Comparator.comparingInt(User::getId)));
    private final static MemoryStore instance = new MemoryStore();

    private MemoryStore() {
    }

    public static MemoryStore getInstance() {
        return instance;
    }

    @Override
    public boolean add(User user) {
        return this.users.add(user);
    }

    @Override
    public boolean update(User user) {
        return delete(user) && this.users.add(user);
    }

    @Override
    public boolean delete(User user) {
        Optional<User> current = findById(user.getId());
        current.ifPresent(this.users::remove);
        return current.isPresent();
    }

    @Override
    public Optional<User> findById(int id) {
        return this.users.stream().filter(user -> user.getId() == id).findFirst();
    }

    @Override
    public List<User> findAll() {
      return new ArrayList<>(this.users);
    }
}