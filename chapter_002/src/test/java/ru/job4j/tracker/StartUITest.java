package ru.job4j.tracker;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import org.junit.After;
import static org.junit.Assert.assertThat;
import org.junit.Before;
/**
 * Test.
 * @author Oleg Buryachenko (mailto:ovburyachenko@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "Oleg", "student", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("Oleg"));
    }
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Oleg", "student"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }
    @Test
    public void whenUserDeleteItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Oleg", "student"));
        String id = item.getId();
        Input input = new StubInput(new String[]{"3", id, "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getPosition(), is(0));
    }
    @Test
    public void whenUserShowAllItemsThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Item item = new Item("Oleg", "student");
        tracker.add(item);
        Item[] items = tracker.findAll();
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                    new StringBuilder()
                            .append("Меню.\r\n0. Add new Item\r\n1." +
                                    " Show all items\r\n2. Edit item\r\n3. " +
                                    "Delete item\r\n4. Find item by Id\r\n5. " +
                                    "Find items by name\r\n6. Exit Program\r\n" +
                                    "Select:\r\n")
                            .append("--------- Список заявок ---------\r\n")
                            .append("0. " + " NAME = " + items[0].getName() + "; " +
                                    "DESC = " + items[0].getDesc() + "; " +
                                    "ID = " + items[0].getId() + "\r\n")
                            .append("---------------------------------\r\n")
                            .append("Меню.\r\n0. Add new Item\r\n1." +
                                    " Show all items\r\n2. Edit item\r\n3. " +
                                    "Delete item\r\n4. Find item by Id\r\n5. " +
                                    "Find items by name\r\n6. Exit Program\r\n" +
                                    "Select:")
                            .append(System.lineSeparator())
                            .toString()
                )
        );
    }
    @Test
    public void whenUserFindItemByIdThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Item item = new Item("Oleg", "student");
        tracker.add(item);
        Item[] items = tracker.findAll();
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("Меню.\r\n0. Add new Item\r\n1." +
                                        " Show all items\r\n2. Edit item\r\n3. " +
                                        "Delete item\r\n4. Find item by Id\r\n5. " +
                                        "Find items by name\r\n6. Exit Program\r\n" +
                                        "Select:\r\n")
                                .append("-------------------------------\r\n")
                                .append("Name = " + items[0].getName() + "; " +
                                        "Desc = " + items[0].getDesc() + "\r\n")
                                .append("-------------------------------\r\n")
                                .append("Меню.\r\n0. Add new Item\r\n1." +
                                        " Show all items\r\n2. Edit item\r\n3. " +
                                        "Delete item\r\n4. Find item by Id\r\n5. " +
                                        "Find items by name\r\n6. Exit Program\r\n" +
                                        "Select:")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
    @Test
    public void whenUserFindItemByNameThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Item item = new Item("Oleg", "student");
        tracker.add(item);
        Item[] items = tracker.findAll();
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("Меню.\r\n0. Add new Item\r\n1." +
                                        " Show all items\r\n2. Edit item\r\n3. " +
                                        "Delete item\r\n4. Find item by Id\r\n5. " +
                                        "Find items by name\r\n6. Exit Program\r\n" +
                                        "Select:\r\n")
                                .append("-----------------------------------\r\n")
                                //.append("Введите индефикатор заявки :\r\n")
                                .append("ID = " + items[0].getId() + "; " +
                                        "Desc = " + items[0].getDesc() + "\r\n")
                                .append("-----------------------------------\r\n")
                                .append("Меню.\r\n0. Add new Item\r\n1." +
                                        " Show all items\r\n2. Edit item\r\n3. " +
                                        "Delete item\r\n4. Find item by Id\r\n5. " +
                                        "Find items by name\r\n6. Exit Program\r\n" +
                                        "Select:")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}