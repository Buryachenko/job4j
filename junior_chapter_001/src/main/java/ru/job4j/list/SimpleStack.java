package ru.job4j.list;
/**
 *
 * Class Класс контейнера типа Stack на базе SimpleArrayList
 * @athor Oleg Buryachenko
 * @since 08.04.19
 * @version 1
 */
public class SimpleStack<T> extends SimpleArrayList<T> {

    public T poll() {
        T result = get(0);
        delete();
        return result;
    }

    public void push(T date) {
        add(date);
    }
}
