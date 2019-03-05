package ru.job4j.filtration;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * @Test
 * @athor Oleg Buryachenko (mailto: ovburyachenko@yandex.ru)
 * @since 0.1
 * @version $Id$
 */
public class MatrixToListTest {
    @Test
    public void whenMatrixToList() {
        Integer[][] matrix = {
                {1, 2},
                {3, 4}
        };
        List<Integer> extended = Arrays.asList(1, 2, 3, 4);
        List<Integer> result = Arrays.stream(matrix).flatMap(Arrays::stream).collect(Collectors.toList());
        assertThat(result, is(extended));
    }
}
