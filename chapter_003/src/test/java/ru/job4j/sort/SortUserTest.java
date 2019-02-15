package ru.job4j.sort;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import java.util.List;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Set;

public class SortUserTest {
    @Test
    public void whenSortUser() {
        List<User> users = Arrays.asList(new User("Oleg", 23), new User("Vika", 18), new User("Alla", 33));
        SortUser sortUser = new SortUser();
        Set<User> result = sortUser.sort(users);
        assertThat(result.iterator().next().getName(), is("Vika"));
    }
}
