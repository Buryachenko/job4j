package ru.job4j.condition;
 /**
  * @author Oleg Buryachenko (mailto:ovburyachenko@yandex.ru)
  * @version $Id$
  * @since 0.1
  */
public class Point {
   public int x;
   public int y;
   public  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public double distanceTo(Point that) {
    // Точка А - это текущая точка. К ней мы обращаемся через оператор this.
    Point a = this;
    // Точка В - это входящая точка. К ней мы можем обратиться напрямую через имя переменной that.
    // или для удобства мы создали новую переменную b и к ней присвоили переменную that.
    Point b = that;
	int x1 = a.x;
    int y1 = a.y;
    int x2 = b.x;
    int y2 = b.y;
    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
  }
}