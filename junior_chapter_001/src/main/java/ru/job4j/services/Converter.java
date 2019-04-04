package ru.job4j.services;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *
 * Class Класс преобразует итератор итераторов в один итератор
 * @athor Buryachenko
 * @since 04.04.19
 * @version 1
 */
public class Converter {
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> its) {
        return new Iterator<Integer>() {
            Iterator<Integer> it = its.next();
            @Override
            public boolean hasNext() {
                if (!it.hasNext()) {
                    if (its.hasNext()) {
                        it = its.next();
                    }
                }
                return it.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return it.next();
            }
        };
    }
}
