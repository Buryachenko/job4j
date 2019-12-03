package ru.job4j.servlets;

import java.util.List;
import java.util.Optional;

public interface Store {
    boolean add(User user);
    boolean update(User user);
    boolean delete(User user);
    Optional<User> findById(int id);
    List<User> findAll();
}
