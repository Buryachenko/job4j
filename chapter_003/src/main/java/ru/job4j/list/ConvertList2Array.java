package ru.job4j.list;
import java.util.List;
/**
 * Class  Класс преобразует список типа List в двумерный массив
 * @author Buryachenko
 * @since 11.02.2019
 * @version 1
 */
public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int rest = list.size() % rows;
        int cells = (rest > 0) ? 1 + list.size() / rows : list.size() / rows;
        int[][] array = new int[rows][cells];
        int cell = 0;
        int row = 0;
        for (Integer element : list) {
            array[row][cell] = element;
            if (cell < cells) {
                cell++;
            }
            if (cell == cells) {
                cell = 0;
                row++;
            }
        }
        return array;
    }
}
