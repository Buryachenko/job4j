package ru.job4j.map;

import java.util.*;
/**
 *
 * Class Класс SimpleHashMap
 * @athor Oleg Buryachenko
 * @since 16.04.19
 * @version 1
 */
public class SimpleHashMap<K, V> implements Iterable<V> {
    private Entry<?, ?>[] table;
    private final int defaultSize = 16;
    private final int maxSize = Integer.MAX_VALUE - 8;
    private final float loadFactor = 0.75f;
    private int count;
    private int threshold;

    public SimpleHashMap() {
        table = new Entry<?, ?>[defaultSize];
        threshold = (int) Math.min(defaultSize * loadFactor, maxSize + 1);
    }

    public boolean insert(K key, V value) {
        boolean result = true;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % table.length;
        Entry<K, V> entry = (Entry<K, V>) table[index];
        if (entry != null) {
            if (entry.hash == hash && entry.key.equals(key)) {
                entry.value = value;
            } else {
                result = false;
            }
        }
        return result && addEntry(hash, key, value, index);
    }

    public V get(K key) {
        int index = (key.hashCode() & 0x7FFFFFFF) % table.length;
        return table[index] != null ? (V) table[index].value : null;
    }

    public boolean delete(K key) {
        boolean result = false;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % table.length;
        if (table[index].key.equals(key)) {
            table[index] = null;
            result = true;
            count--;
        }
        return result;
    }

    private boolean addEntry(int hash, K key, V value, int index) {
        if (count >= threshold) {
            rehash();
            hash = key.hashCode();
            index = (hash & 0x7FFFFFFF) % table.length;
        }
        table[index] = new Entry<>(hash, key, value);
        count++;
        return true;
    }

    protected void rehash() {
        int oldCapacity = table.length;
        int newCapacity = (oldCapacity << 1) + 1;
        Entry<?, ?>[] oldMap = table;
        if (newCapacity - maxSize > 0) {
            if (oldCapacity == maxSize) {
                return;
            }
            newCapacity = maxSize;
        }
        threshold = (int) Math.min(newCapacity * loadFactor, maxSize + 1);
        Entry<?, ?>[] newMap = new Entry<?, ?>[newCapacity];
        table = newMap;
        for (int i = 0; i < oldCapacity; i++) {
            if (oldMap[i] != null) {
               int index = (oldMap[i].hash & 0x7FFFFFFF) % oldCapacity;
               newMap[index] = oldMap[i];
            }
        }
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            int index = 0;
            int modCount = count;
            int size = table.length;
            Entry<?, ?> basket;

            @Override
            public boolean hasNext() {
                if (modCount != count) {
                    throw new ConcurrentModificationException();
                }
                while (basket == null && index < size) {
                    basket = table[index++];
                }
                return basket != null;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                V result = (V) basket.value;
                basket = null;
                return result;
            }
        };
    }

    private static class Entry<K, V> {
        private K key;
        private V value;
        private int hash;

        Entry(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }
}
