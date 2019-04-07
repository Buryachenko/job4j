package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *
 * Class Класс обертка массива
 * @athor Buryachenko
 * @since 06.04.19
 * @version 1
 */
public class SimpleArray<T> implements Iterable<T> {
    private final Object[] objects;
    private final int size;
    private int position = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
        this.size = size;
    }

    public void add(T model) {
        if (position >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.objects[position++] = model;
    }

    public T set(int index, T model) {
        if (index >= position) {
            throw new NoSuchElementException();
        }
        T result = (T) this.objects[index];
        this.objects[index] = model;
        return result;
    }

    public T remove(int index) {
        if (index >= position) {
            throw new NoSuchElementException();
        }
        T result = (T) this.objects[index];
        System.arraycopy(objects, index + 1, objects, index, position - index - 1);
        position--;
        this.objects[position] = null;
        return result;
    }

    public T get(int index) {
        if (index >= position) {
           throw new NoSuchElementException();
        }
        return (T) this.objects[index];
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            int posIt = 0;
            @Override
            public boolean hasNext() {
                return posIt < size && objects[posIt] != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) objects[posIt++];
            }
        };
    }
}
