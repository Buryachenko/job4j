package ru.job4j.array;

/**
 * Class Класс проверяет массив, заполнен массив true или false.
 * @author Buryachenko
 * @since 16.09.2018
 * @version 1
 */

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;
		boolean prev = data[0];
		
        for (int i = 0; i < data.length; i++) {
			if(data[i] == prev){
				result = true;
			}
			else{
				result = false;
				break;
			}
		}
        return result;
    }
}