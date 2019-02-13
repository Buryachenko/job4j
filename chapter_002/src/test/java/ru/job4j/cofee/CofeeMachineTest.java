package ru.job4j.cofee;
import java.util.Arrays;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.List;
/**
 * Test.
 *
 * @author Oleg Buryachenko (mailto:ovburyachenko@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class CofeeMachineTest {
    @Test
    public void whenPrice35Value100() {
        CofeeMachine cofeeMachine = new CofeeMachine();
        List<Integer> changes = cofeeMachine.changes(100, 35);
        assertThat(changes, is(Arrays.asList(10, 10, 10, 10, 10, 10, 5)));
    }

    @Test
    public void whenPrice32Value50() {
        CofeeMachine cofeeMachine = new CofeeMachine();
        List<Integer> changes = cofeeMachine.changes(50, 32);
        assertThat(changes, is(Arrays.asList(10, 5, 2, 1)));
    }
}