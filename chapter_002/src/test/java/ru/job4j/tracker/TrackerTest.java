package ru.job4j.tracker;
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
public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2");
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
        tracker.delete(tracker.findAll().get(0).getId());
        assertThat(0, is(tracker.findAll().size()));
    }
    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        for (int i = 0; i < 100; i++) {
            Item item = new Item(Integer.toString(i), "testDescription");
            tracker.add(item);
        }
        int index = 0;
        while (index < 100) {
            String id = tracker.findByName(Integer.toString(index)).get(0).getId();
            tracker.delete(id);
            index = index + 2;
        }
        List<Item> items = tracker.findAll();
        for (int i = 0; i < tracker.getPosition(); i++) {
            assertThat(Integer.toString(i * 2 + 1), is(items.get(i).getName()));
        }
    }
}