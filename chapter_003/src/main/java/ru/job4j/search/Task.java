package ru.job4j.search;
/**
 *
 * Class Класс задачи с приоритетом
 * @athor Buryachenko
 * @since 09.02.19
 * @version 1
 */
public class Task {
    private String desc;
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }
}

