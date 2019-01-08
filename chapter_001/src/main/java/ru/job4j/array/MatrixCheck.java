package ru.job4j.array;
/**
 * Class  Класс проверяет, что все элементы в квадратной матрице по диагоналям равны true или false.
 * @author Buryachenko
 * @since 08.01.2019
 * @version 1
 */
public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;

		int column = data[0].length - 1;

		for (int i = 0; i < data.length; i++) {
			if (data[0][0] != data[i][i]) {
				result = false;
				break;
			}
			if (data[0][data[0].length - 1] != data[i][column]) {
				result = false;
				break;
			}
			column--;
		}
        return result;
    }
}