package ru.job4j.pseudo;
/**
 *  Class Класс (контекст) посредством интерфейса Shape печатает псевдокартинку на консоль.
 *  @author Buryachenko
 *  @since 14.01.2019
 *  @version 1
 */
public class Paint {
    public void draw(Shape shape) {
        System.out.print(shape.draw());
    }
    
    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.draw(new Square());
        paint.draw(new Triangle());
    }
}
