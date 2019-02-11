package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int index = 0;
        int rest = list.size() % rows;
        int cells = (rest > 0) ? 1 + list.size() / rows : list.size() / rows;
        int[][] array = new int[rows][cells];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cells; j++) {
                if (index < list.size()) {
                    array[i][j] = list.get(index);
                    index++;
                } else {
                    array[i][j] = 0;
                }
            }
        }
        return array;
    }
}
