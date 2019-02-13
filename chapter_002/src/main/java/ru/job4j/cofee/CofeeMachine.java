package ru.job4j.cofee;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * Class Класс кофемашины
 * @athor Buryachenko
 * @since 10.02.2019
 * @version 1
 */
public class CofeeMachine {
    private List<Integer> monets;

    public CofeeMachine() {
        monets = Arrays.asList(10, 5, 2, 1);
    }

    List<Integer> changes(int value, int price) {
        List<Integer> result = new ArrayList<>();
        if (value > price) {
            int rest = value - price;
            for (Integer moneta : monets) {
                int amount = rest / moneta;
                for (int i = 0; i < amount; i++) {
                    result.add(moneta);
                }
                rest = rest % moneta;
            }
        }
        return result;
    }
}