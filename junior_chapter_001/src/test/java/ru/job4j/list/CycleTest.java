package ru.job4j.list;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 *
 * @Test Тест метода hasCycle, определяющий цикличность в связанном списке
 * @athor Oleg Buryachenko (mailto: ovburyachenko@yandex.ru)
 * @since 0.1
 * @version $Id$
 */
public class CycleTest {

    private Node first, two, third, four;

    @Before
    public void init() {
        first = new Node(1);
        two = new Node(2);
        third = new Node(3);
        four = new Node(4);
    }

    public boolean hasCycle(Node first) {
        boolean result = false;
        Node fast = first;
        Node slow = first;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Test
    public void whenCycleLastToFirstResultTrue() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertThat(hasCycle(first), is(true));
    }

    @Test
    public void whenCycleLastToTwoResultTrue() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = two;
        assertThat(hasCycle(first), is(true));
    }

    @Test
    public void whenCycleLastToThirdResultTrue() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = third;
        assertThat(hasCycle(first), is(true));
    }

    @Test
    public void whenCycleLastToNullResultFalse() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;
        assertThat(hasCycle(first), is(false));
    }

    @Test
    public void whenCycleFirstNextToNullResultFalse() {
        first.next = null;
        assertThat(hasCycle(first), is(false));
    }

    class Node<T> {
        T value;
        Node<T> next;
        Node(T value) {
            this.value = value;
        }
    }
}
