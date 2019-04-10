package ru.job4j.set;
import ru.job4j.generic.SimpleArray;

import java.util.Iterator;
/**
 *
 * Class Класс контейнера типа Set на базе SimpleArray
 * @athor Oleg Buryachenko
 * @since 10.04.19
 * @version 1
 */
public class SimpleSet<E> implements Iterable<E> {
    private SimpleArray<E> simpleArray;

    public SimpleSet(final int size) {
        this.simpleArray = new SimpleArray<>(size);
    }

    public void add(E value) {
        if (!findDuplicate(value)) {
            this.simpleArray.add(value);
        }
    }

    private boolean findDuplicate(E value) {
        boolean result = false;
        for (E date : simpleArray) {
            if (date.equals(value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return simpleArray.iterator();
    }
}
