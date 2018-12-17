package ru.job4j.array;
import java.util.Arrays;
/**
 * Class  Класс удаляет дубликаты в массиве
 * @author Buryachenko
 * @since 18.12.2018
 * @version 1
 */
public class ArrayDuplicate{
	/**
	 * Убирает все дубликаты строк из массива
	 * @param array массив строк
	 * @return массив без дупликатов
	 */
	public String[] remove(String[] array){
		String str;
		int temp_length = array.length;
		for(int i = 0; i < temp_length; i++){
			str = array[i];
			for(int j = (temp_length - 1); j > i; j--){
				if(str.equals(array[j])) {
					String temp = array[j];
					array[j] = array[temp_length - 1];
					array[temp_length - 1] = temp;
					temp_length = temp_length - 1;
				}
			}
		}
		return Arrays.copyOf(array, temp_length);
	}
}

