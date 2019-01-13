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
        int number = 0;
        while (indexFirst < first.length && indexSecond < second.length) {
            if (first[indexFirst] < second[indexSecond]) {
                result[number] = first[indexFirst];
                indexFirst++;
            } else {
                result[number] = second[indexSecond];
                indexSecond++;
            }
            number++;
        }
        while (indexFirst < first.length) {
            result[number] = first[indexFirst];
            indexFirst++;
            number++;
        }
        while (indexSecond < second.length) {
            result[number] = second[indexSecond];
            indexSecond++;
            number++;
        }
        return result;
    }
}
