package ru.job4j.array;

/**
 * Class Класс сортирует массив целых чисел, используя алгоритм сортировки пузырьком
 * @author Buryachenko
 * @since 03.10.2018
 * @version 1
 */
public class BubbleSort {

    /**
     * Cортирует массив целых чисел, используя алгоритм сортировки пузырьком
     * @param array массив целых чисел
     * @return отсортированный массив
     */
	 
    public int[] sort(int[] array) {
		int n = array.length;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < (n - i); j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
        return array;
    }
}