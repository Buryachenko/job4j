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
        int size = str1.length() > str2.length() ? str2.length() : str1.length();
        for (int i = 0; i < size; i++) {
            if (first[i] != second[i]) {
                result = first[i] > second[i] ? 1 : -1;
                break;
            }
        }
        if (result == 0 & str1.length() > str2.length()) {
            result = 1;
        } else if (result == 0 & str1.length() < str2.length()) {
            result = -1;
        }
        return result;
    }
}
