package ru.job4j.loop;

/**
 * Class Класс для вычисления суммы четных чисел в диапазоне.
 * @author Buryachenko
 * @since 16.09.2018
 * @version 1
 */
 
public class Counter {
	/**
	* Метод должен вычислить сумму четных чисел в диапазоне от start до finish.
	*
	* @return Вернуть cумму.
	*/
    public int add(int start, int finish) {

 		int even = start & 0xFFFFFFFE;
		if(even < start){
			start = even + 2;
		}

		int sum = 0;
		while(start <= finish) {
			sum = sum + start;
			start = start + 2;
		}
		
        return sum;
    }
}