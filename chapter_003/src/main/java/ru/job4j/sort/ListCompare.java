package ru.job4j.sort;
import java.util.Comparator;
/**
 * Class Класс сравнивает строки
 * @author Buryachenko
 * @since 20.02.19
 * @version 1
 */
public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        char[] first = str1.toCharArray();
        char[] second = str2.toCharArray();
        int result = 0;
        int size = Math.min(str1.length(), str2.length());
        for (int i = 0; i < size; i++) {
            if (first[i] != second[i]) {
                result = Integer.compare(first[i], second[i]);
                break;
            }
        }
        return result == 0 ? Integer.compare(str1.length(), str2.length()) : result;
    }
}
