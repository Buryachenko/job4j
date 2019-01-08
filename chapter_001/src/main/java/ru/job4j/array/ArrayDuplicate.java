package ru.job4j.array;
import java.util.Arrays;
/**
 * Class  Класс удаляет дубликаты в массиве
 * @author Buryachenko
 * @since 18.12.2018
 * @version 1
 */
public class ArrayDuplicate {
	/**
	 * Убирает все дубликаты строк из массива
	 * @param array массив строк
	 * @return массив без дупликатов
	 */
	public String[] remove(String[] array) {
		String str;
		int length = array.length;
		for (int i = 0; i < length; i++) {
			str = array[i];
			for (int j = (length - 1); j > i; j--) {
				if (str.equals(array[j])) {
					String temp = array[j];
					array[j] = array[length - 1];
					array[length - 1] = temp;
					length--;
				}
			}
		}
		return Arrays.copyOf(array, length);
	}
}

