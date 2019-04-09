package ru.job4j.list;
/**
 *
 * Class Класс контейнера типа Queue, реализованный на двух объектах типа SimpleStack
 * @athor Oleg Buryachenko
 * @since 09.04.19
 * @version 1
 */
public class SimpleQueue<T> {
    private SimpleStack<T> stackFirst;
    private SimpleStack<T> stackSecond;

    public SimpleQueue() {
        stackFirst = new SimpleStack<>();
        stackSecond = new SimpleStack<>();
    }

    public T poll() {
        if (stackSecond.getSize() == 0) {
            while (stackFirst.getSize() != 0) {
                stackSecond.push(stackFirst.poll());
            }
        }
        return stackSecond.poll();
    }

    public void push(T value) {
        stackFirst.push(value);
    }
}
