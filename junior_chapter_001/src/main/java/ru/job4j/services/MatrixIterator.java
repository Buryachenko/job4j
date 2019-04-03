package ru.job4j.services;
import java.util.Iterator;
/**
 *
 * Class Класс предоставляет итератор для матрицы
 * @athor Buryachenko
 * @since 03.04.19
 * @version 1
 */
public class MatrixIterator implements Iterator {

    private int row = 0;
    private int column = 0;
    private final int[][] values;

    public MatrixIterator(final int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        if (this.values[row].length > column) {
            result = true;
        } else {
            row++;
            if (this.values.length > row) {
                column = 0;
                result = true;
            }
        }
        return result;
    }

    @Override
    public Object next() {
        return hasNext() ? this.values[row][column++] : null;
    }
}
