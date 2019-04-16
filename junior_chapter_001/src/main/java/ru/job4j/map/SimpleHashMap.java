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
    private int count;
    private int threshold;

    public SimpleHashMap() {
        table = new Entry<?, ?>[defaultSize];
        threshold = defaultSize;
    }

    public boolean insert(K key, V value) {
        boolean result = true;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % table.length;
        Entry<K, V> entry = (Entry<K, V>) table[index];
        if (entry != null) {
            if (entry.hash == hash) {
                if (entry.key.equals(key)) {
                    V old = entry.value;
                    entry.value = value;
                } else {
                    result = false;
                }
            }
        }
        return result && addEntry(hash, key, value, index);
    }

    public V get(K key) {
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % table.length;
        Entry<?, ?> result = table[index];
        return (result != null && (result.hash == hash) && result.key.equals(key)) ? (V) result.value : null;
    }

    public boolean delete(K key) {
        int hash = key.hashCode();
        int pos = (hash & 0x7FFFFFFF) % table.length;
        Entry<K, V> entry = (Entry<K, V>) table[pos];
        Entry<K, V> first = (Entry<K, V>) table[pos];
        Entry<K, V> prev = (Entry<K, V>) table[pos];
        while (entry != null) {
            if (entry.key.equals(key)) {
                if (first == entry) {
                    table[pos] = entry.next;
                } else {
                    prev.next = entry.next;
                }
                count--;
                break;
            }
            prev = entry;
            entry = entry.next;
        }
        return entry != null;
    }

    private boolean addEntry(int hash, K key, V value, int index) {
        if (count >= threshold) {
            rehash();
            table = table;
            hash = key.hashCode();
            index = (hash & 0x7FFFFFFF) % table.length;
        }
        Entry<K, V> e = (Entry<K, V>) table[index];
        table[index] = new Entry<>(hash, key, value, e);
        count++;
        return true;
    }

    protected void rehash() {
        int oldCapacity = table.length;
        int newCapacity = (oldCapacity << 1) + 1;
        if (newCapacity - maxSize > 0) {
            if (oldCapacity == maxSize) {
                return;
            }
            newCapacity = maxSize;
        }
        threshold = Math.min(newCapacity, maxSize + 1);
        table = Arrays.copyOf(table, newCapacity);
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
                int i = index;
                while (basket == null && i < size) {
                    basket = table[i];
                    index = i;
                    i++;
                }
                return basket != null;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Entry<?, ?> e = basket;
                basket = basket.next;
                if (basket == null) {
                    index++;
                }
                return (V) e.getValue();
            }
        };
    }

    private static class Entry<K, V> {
        private K key;
        private V value;
        private int hash;
        private Entry<K, V> next;

        Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public V getValue() {
            return this.value;
        }
    }
}
