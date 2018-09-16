package ru.job4j.loop;

/**
 * Class Класс для вычисления факториала.
 * @author Buryachenko
 * @since 16.09.2018
 * @version 1
 */
 
public class Factorial {
	/**
	* Метод должен вычислить факториал числа n.
	*
	* @return факториал.
	*/
    public int calc(int n) {
		int factorial = 1;
 		for(int i = 1; i <= n; i++){
			factorial = factorial * i;
		}
		
        return factorial;
    }
}