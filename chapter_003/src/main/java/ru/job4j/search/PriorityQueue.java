package ru.job4j.search;

import java.util.LinkedList;
/**
 *
 * Class Класс очереди задач с приоритетом
 * @athor Buryachenko
 * @since 09.02.19
 * @version 1
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        var size = tasks.size();
        for (var i = 0; i < size; i++) {
            if (task.getPriority() <= tasks.get(i).getPriority()) {
                tasks.add(i, task);
                break;
            }
        }
        if (size == tasks.size()) {
            tasks.addLast(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
