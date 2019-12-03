package ru.job4j.servlets;

public interface Message {
    /**
     * Sent to type.
     *
     * @return type.
     */

    Type type();

    enum Type {
        ADD,
        UPDATE,
        DELETE
    }
}
