package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 *
 * @author Oleg Buryachenko (mailto:ovburyachenko@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ArrayCombTest {
    @Test
    public void whenSortBubbleArray() {
        int[] first = new int[] {1, 2, 3, 4, 5};
        int[] second = new int[] {6, 7, 8, 9, 10};
        ArrayComb comb = new ArrayComb();
        int[] result = comb.combiningTwoArrayToOne(first, second);
        int[] expect = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertThat(result, is(expect));
    }
    @Test
    public void whenArrayFirstLarge() {
        int[] first = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] second = new int[] {1, 1, 3, 8, 9};
        ArrayComb comb = new ArrayComb();
        int[] result = comb.combiningTwoArrayToOne(first, second);
        int[] expect = new int[] {1, 1, 1, 2, 3, 3, 4, 5, 6, 7, 8, 8, 9, 9, 10};
        assertThat(result, is(expect));
    }
    @Test
    public void whenArraySecondLarge() {
        int[] first = new int[] {10, 11, 12};
        int[] second = new int[] {1, 2, 3, 4, 4, 6, 7, 8, 8, 8, 11, 12};
        ArrayComb comb = new ArrayComb();
        int[] result = comb.combiningTwoArrayToOne(first, second);
        int[] expect = new int[] {1, 2, 3, 4, 4, 6, 7, 8, 8, 8, 10, 11, 11, 12, 12};
        assertThat(result, is(expect));
    }
}