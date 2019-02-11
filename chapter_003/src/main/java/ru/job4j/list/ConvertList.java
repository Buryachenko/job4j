package ru.job4j.list;
import java.util.List;
import java.util.ArrayList;
/**
 * Class  Класс объединяет лист массивов в один List Integer
 * @author Buryachenko
 * @since 11.02.2019
 * @version 1
 */
public class ConvertList {
    public List<Integer> convert (List<int[]> list) {
        List<Integer> result = new ArrayList();
        for (int[] str : list) {
            for (int num : str) {
                result.add(num);
            }
        }
        return result;
    }
}
