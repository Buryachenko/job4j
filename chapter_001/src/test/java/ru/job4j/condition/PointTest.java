package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Oleg Buryachenko (mailto:ovburyachenko@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PointTest {
    @Test
    public void calculateDistanceAtoB() {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        double formula = Math.sqrt(Math.pow(2 - 0, 2) + Math.pow(5 - 1, 2));
        double result = a.distanceTo(b);
        assertThat(result, is(formula));
    }
}