package ru.job4j.list;
import java.util.ArrayList;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Oleg Buryachenko (mailto:ovburyachenko@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ConvertListTest {
@Test
public void when3on6ArrayThenList4() {
        List<int[]> inList = new ArrayList();
        inList.add(new int[] {1, 2, 3});
        inList.add(new int[] {4, 5, 6, 7, 8, 9});
        ConvertList list = new ConvertList();
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 8, 9
        );
        List<Integer> result = list.convert(inList);
        assertThat(result, is(expect));
    }
}
