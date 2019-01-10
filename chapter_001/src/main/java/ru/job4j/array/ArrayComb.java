package ru.job4j.array;
/**
 * Class  Класс объединяет два массива в один
 * @author Buryachenko
 * @since 18.12.2018
 * @version 1
 */
public class ArrayComb {
    public int[] combiningTwoArrayToOne(int[] first, int[] second) {
        int sizeArray = first.length + second.length;
        int[] result = new int[sizeArray];
        int indexFirst = 0;
        int indexSecond = 0;
        if (first[first.length - 1] > second[0]) {
            int[] temp = second;
            second = first;
            first = temp;
        }
        for (int i = 0; i < sizeArray; i++) {
            if (indexFirst < first.length) {
                result[i] = first[indexFirst];
                indexFirst++;
            } else {
                if (indexSecond < second.length) {
                    result[i] = second[indexSecond];
                    indexSecond++;
                }
            }
        }
        return result;
    }
}
