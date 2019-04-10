package ru.job4j.map;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @Test
 * @athor Oleg Buryachenko (mailto: ovburyachenko@yandex.ru)
 * @since 0.1
 * @version $Id$
 */
public class MapUserTest {
    @Test
    public void whenCreateMapTwoUser() {
        User first = new User();
        User second = new User();
        Map<User, String> map = new HashMap<>();
        map.put(first, "First");
        map.put(second, "Second");
        System.out.println(map);
    }
}