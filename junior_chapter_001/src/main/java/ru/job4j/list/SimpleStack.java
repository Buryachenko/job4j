package ru.job4j.list;
/**
 *
 * Class Класс контейнера типа Stack на базе SimpleArrayList
 * @athor Oleg Buryachenko
 * @since 08.04.19
 * @version 1
 */
public class SimpleStack<T> {

    private SimpleArrayList<T> list = new SimpleArrayList<>();

    public T poll() {
        return list.delete();
    }

    public void push(T date) {
        list.add(date);
    }
    public int getSize() {
        return list.getSize();
    }
}
