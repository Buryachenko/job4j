package ru.job4j.array;

/**
 * Class Класс заполняет массив степенями чисел.
 * @author Buryachenko
 * @since 16.09.2018
 * @version 1
 */
 
public class Square {
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
		for (int i = 0; i < bound; i++) {
			rst[i] = (int) Math.pow((i + 1), 2);
		}
        return rst;
    }
}