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
        int[] first = new int[] {1, 5, 4, 2, 3};
        int[] second = new int[] {6, 9, 8, 10, 7};
        BubbleSort bubble = new BubbleSort();
        int[] arrayFirst = bubble.sort(first);
        int[] arraySecond = bubble.sort(second);
        ArrayComb comb = new ArrayComb();
        int[] result = comb.combiningTwoArrayToOne(arraySecond, arrayFirst);
        int[] expect = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertThat(result, is(expect));
    }
    @Test
    public void whenArrayFirstLarge() {
        int[] first = new int[] {1, 5, 4, 2, 3, 6, 9, 8, 10, 7};
        int[] second = new int[] {11, 13, 14, 15, 12};
        BubbleSort bubble = new BubbleSort();
        int[] arrayFirst = bubble.sort(first);
        int[] arraySecond = bubble.sort(second);
        ArrayComb comb = new ArrayComb();
        int[] result = comb.combiningTwoArrayToOne(arraySecond, arrayFirst);
        int[] expect = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        assertThat(result, is(expect));
    }
    @Test
    public void whenArraySecondLarge() {
        int[] first = new int[] {15, 13, 14};
        int[] second = new int[] {1, 2, 3, 9, 4, 6, 7, 10, 5, 11, 8, 12};
        BubbleSort bubble = new BubbleSort();
        int[] arrayFirst = bubble.sort(first);
        int[] arraySecond = bubble.sort(second);
        ArrayComb comb = new ArrayComb();
        int[] result = comb.combiningTwoArrayToOne(arraySecond, arrayFirst);
        int[] expect = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        assertThat(result, is(expect));
    }
}