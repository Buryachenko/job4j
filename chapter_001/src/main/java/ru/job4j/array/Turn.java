package ru.job4j.array;

/**
 * Class Класс переворачивает массив.
 * @author Buryachenko
 * @since 16.09.2018
 * @version 1
 */

public class Turn {
    public int[] turn(int[] array) {
		int width = (int)(array.length/2);
        for (int i = 0; i < width; i++) {
			int temp = array[array.length - 1 - i];
			array[array.length - 1 - i] = array[i];
			array[i] = temp;
		}
        return array;
    }
}