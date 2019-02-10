package ru.job4j.cofee;

/**
 *
 * Class Класс кофемашины
 * @athor Buryachenko
 * @since 10.02.2019
 * @version 1
 */
public class CofeeMachine {
    int[] changes(int value, int price) {
        int[] result = null;
        if (value > price) {
            int rest = value - price;
            int d10 = rest / 10;
            int d5 = (rest % 10) / 5;
            int d2 = ((rest % 10) % 5) / 2;
            int d1 = ((rest % 10) % 5) % 2;
            result = new int[d10 + d5 + d2 + d1];
            for (int i = 0; i < d10; i++) {
               result[i] = 10;
            }
            for (int i = d10; i < d10 + d5; i++) {
                result[i] = 5;
            }
            for (int i = d10 + d5; i < d10 + d5 + d2; i++) {
                result[i] = 2;
            }
            for (int i = d10 + d5 + d2; i < d10 + d5 + d2 + d1; i++) {
                result[i] = 1;
            }
        }
        return result;
    }
}
