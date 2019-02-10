package ru.job4j.cofee;
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
public class CofeeMachineTest {
    @Test
    public void whenPrice35Value100() {
        CofeeMachine cofeeMachine = new CofeeMachine();
        int[] changes = cofeeMachine.changes(100, 35);
        assertThat(changes, is(new int[] {10, 10, 10, 10, 10, 10, 5}));
    }

    @Test
    public void whenPrice32Value50() {
        CofeeMachine cofeeMachine = new CofeeMachine();
        int[] changes = cofeeMachine.changes(50, 32);
        assertThat(changes, is(new int[] {10, 5, 2, 1}));
    }
}
