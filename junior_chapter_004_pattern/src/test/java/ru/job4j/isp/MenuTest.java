package ru.job4j.isp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MenuTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    Menu menu = new Menu();

    @Before
    public void menuAddItem() {
        menu.add(new ItemMenu("1", "1"));
        menu.get("1").add(new ItemMenu("1.1","- 1.1"));
        menu.get("1").get("1.1").add(new ItemMenu("1.1.1", "--- 1.1.1"));
        menu.get("1").get("1.1").get("1.1.1").add(new ItemMenu("1.1.1.1", "---- 1.1.1.1"));
        menu.get("1").get("1.1").add(new ItemMenu("1.1.2", "--- 1.1.2"));
        menu.get("1").add(new ItemMenu("1.2","- 1.2"));
        menu.get("1").get("1.2").add(new ItemMenu("1.2.1", "--- 1.2.1"));
        menu.add(new ItemMenu("2", "2"));
        menu.get("2").add(new ItemMenu("2.1", "- 2.1"));
        menu.add(new ItemMenu("3", "3"));
    }

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
    public void whenShowMenu() {
        menu.show();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("Меню:")
                                .append(System.lineSeparator())
                                .append("1")
                                .append(System.lineSeparator())
                                .append("- 1.1")
                                .append(System.lineSeparator())
                                .append("--- 1.1.1")
                                .append(System.lineSeparator())
                                .append("---- 1.1.1.1")
                                .append(System.lineSeparator())
                                .append("--- 1.1.2")
                                .append(System.lineSeparator())
                                .append("- 1.2")
                                .append(System.lineSeparator())
                                .append("--- 1.2.1")
                                .append(System.lineSeparator())
                                .append("2")
                                .append(System.lineSeparator())
                                .append("- 2.1")
                                .append(System.lineSeparator())
                                .append("3")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenExecuteMenu() {
        menu.get("1").get("1.1").get("1.1.1").execute("Пункт 1.1.1 выполнен", System.out::println);
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("Пункт 1.1.1 выполнен")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}