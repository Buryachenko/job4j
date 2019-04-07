package ru.job4j.generic;

import java.util.ArrayList;

public abstract class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> simpleArray;

    public AbstractStore(int size) {
        simpleArray = new SimpleArray<>(size);
    }
    @Override
    public void add(T model) {
        simpleArray.add(model);
    }
    @Override
    public boolean replace(String id, T model) {
        int index = 0;
        boolean result = false;
        for (T t : simpleArray) {
            if (t.getId().equals(id)) {
                simpleArray.set(index, model);
                result = true;
                break;
            }
            index++;
        }
        return result;
    }
    @Override
    public boolean delete(String id) {
        int index = 0;
        boolean result = false;
        for (T t : simpleArray) {
            if (t.getId().equals(id)) {
                simpleArray.remove(index);
                result = true;
                break;
            }
            index++;
        }
        return result;
    }
    @Override
    public T findById(String id) {
        T result = null;
        for (T t : simpleArray) {
            if (t.getId().equals(id)) {
                result = t;
                break;
            }
        }
        return result;
    }
}
