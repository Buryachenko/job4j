package ru.job4j.function;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 *
 * @Test
 * @author Oleg Buryachenko (mailto: ovburyachenko@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class FunctionTest {
    MathFunction function = new MathFunction();

    public class MathFunction {
        public List<Double> diapason(int start, int finish, Function<Double, Double> func) {
            List<Double> result = new ArrayList<>();
            for (int i = start; i < finish; i++) {
                result.add(new BigDecimal(func.apply((double) i)).setScale(1, RoundingMode.HALF_UP).doubleValue());
            }
            return result;
        }
    }

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = function.diapason(0, 3, x -> 3 * x * x + 5 * x + 10);
        List<Double> expected = Arrays.asList(10D, 18D, 32D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        List<Double> result = function.diapason(1, 4, Math::log10);
        List<Double> expected = Arrays.asList(0D, 0.3D, 0.5D);
        assertThat(result, is(expected));
    }
}
