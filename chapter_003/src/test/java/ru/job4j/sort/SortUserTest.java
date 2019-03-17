package ru.job4j.sort;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Oleg Buryachenko (mailto:ovburyachenko@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class SortUserTest {
    @Test
    public void whenSortUser() {
        List<User> users = List.of(new User("Oleg", 23), new User("Vika", 18), new User("Alla", 33));
        SortUser sortUser = new SortUser();
        Set<User> result = sortUser.sort(users);
        Set<User> expected = Set.of(new User("Vika", 18), new User("Oleg", 23), new User("Alla", 33));
        assertThat(expected, is(result));
    }

    @Test
    public void whenSortNameLength() {
        List<User> users = Arrays.asList(new User("Viktoria", 23), new User("Ivan", 18), new User("Anton", 33));
        SortUser sortUser = new SortUser();
        List<User> result = sortUser.sortNameLength(users);
        assertThat(result.iterator().next().getName(), is("Ivan"));
    }

    @Test
    public void whenSortByAllFields() {
        List<User> users = Arrays.asList(new User("Sergey", 25), new User("Ivan", 30), new User("Sergey", 20), new User("Ivan", 25));
        List<User> expect = Arrays.asList(new User("Ivan", 25), new User("Ivan", 30), new User("Sergey", 20), new User("Sergey", 25));
        SortUser sortUser = new SortUser();
        List<User> result = sortUser.sortByAllFields(users);
        assertEquals(result, expect);
    }
}