package ru.job4j.list;

import java.util.*;

public class Box<E> implements Iterable<E> {
    private Object[] container;
    private int position = 0;
    private final int defaultSize = 1;
    private final int maxSize = Integer.MAX_VALUE - 8;

    public Box() {
        container = new Object[defaultSize];
    }
    public void add(E data) {
        if (position >= container.length) {
            container = rising();
        }
        container[position++] = data;
    }

    public E get(int index) {
        if (index >= position) {
            throw new NoSuchElementException();
        }
        return (E) this.container[index];
    }

    private Object[] rising() {
        if (position >= maxSize) {
            throw new OutOfMemoryError();
        }
        int newCapacity = (container.length << 1) + 1;
        if (newCapacity - maxSize >= 0) {
            newCapacity = maxSize;
        }
        return Arrays.copyOf(container, newCapacity);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = position;
            int posIt = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != position) {
                    throw new ConcurrentModificationException();
                }
                return posIt < position;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[posIt++];
            }
        };
    }
}