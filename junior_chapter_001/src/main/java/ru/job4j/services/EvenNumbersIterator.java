package ru.job4j.services;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *
 * Class Класс предоставляет итератор четных чисел
 * @athor Buryachenko
 * @since 03.04.19
 * @version 1
 */
public class EvenNumbersIterator implements Iterator<Integer> {
    private final int[] numbers;
    private int index = 0;

    public EvenNumbersIterator(final int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = index; i < numbers.length; i++) {
            if(this.numbers[i]%2 == 0) {
                index = i;
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Integer next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return numbers[index++];
    }
}
