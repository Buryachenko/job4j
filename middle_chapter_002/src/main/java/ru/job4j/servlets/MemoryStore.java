package ru.job4j.servlets;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryStore implements Store {
    private final Map<Integer, User> users = new ConcurrentHashMap<>();
    private static final  MemoryStore instance = new MemoryStore();

    private MemoryStore() {
    }

    public static MemoryStore getInstance() {
        return instance;
    }

    @Override
    public boolean add(User user) {
        return Objects.equals(this.users.put(user.getId(), user), user);
    }

    @Override
    public boolean update(User user) {
        return Objects.equals(this.users.put(user.getId(), user), user);
    }

    @Override
    public boolean delete(User user) {
        return !Objects.equals(this.users.remove(user.getId()), null);
    }

    @Override
    public Optional<User> findById(int id) {
        return Optional.of(this.users.get(id));
    }

    @Override
    public List<User> findAll() {
      return new ArrayList<>(this.users.values());
    }
}