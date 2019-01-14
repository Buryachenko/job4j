package ru.job4j.pseudo;
/**
 *  Class Класс преоразуют фигуру треугольник в строку.
 *  @author Buryachenko
 *  @since 14.01.2019
 *  @version 1
 */
public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder figura = new StringBuilder();
        figura.append("+");
        figura.append("+++");
        figura.append("+++++");
        figura.append("+++++++\r\n");
        return figura.toString();
    }
}
