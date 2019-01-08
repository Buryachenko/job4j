package ru.job4j.max;

/**
 * Class Класс для вычисления максимума из двух чисел.
 * @author Buryachenko
 * @since 29.08.2018
 * @version 1
 */

public class Max {
	/**
	 * Method max.
	 * @param first, second.
	 * @return max value.
	 */
	public int max(int first, int second) {
		return first > second ? first : second;
	}

    /**
     * Method max.
     * @param first, second, third.
     * @return max value.
     */
    public int max(int first, int second,  int third) {
        return max(max(first, second), third);
    }
}	