package ru.job4j.loop;
/**
 * Class Класс для построения шахматной доски в псевдографике.
 * @author Buryachenko
 * @since 16.09.2018
 * @version 1
 */
public class Board {
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) == ((i + j) & 0xFFFFFFFE)) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}