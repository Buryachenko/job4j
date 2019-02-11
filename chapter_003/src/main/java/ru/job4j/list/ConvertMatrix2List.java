package ru.job4j.list;
import java.util.ArrayList;
import java.util.List;
/**
 * Class  Класс конвертирует двумерный массив в ArrayList
 * @author Buryachenko
 * @since 11.02.2019
 * @version 1
 */
public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] strMatrix : array) {
            for (int num : strMatrix) {
                list.add(num);
            }
        }
        return list;
    }
}
