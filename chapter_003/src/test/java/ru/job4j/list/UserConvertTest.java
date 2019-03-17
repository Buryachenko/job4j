package ru.job4j.list;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Oleg Buryachenko (mailto:ovburyachenko@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class UserConvertTest {
    
    @Test
    public void whenListConvertHashMap() {     
        List<User> list = List.of(
                    new User(0, "Ivan", "Tomsk"),
                    new User(1, "Olga", "Moscow")
        );
        UserConvert userConvert = new UserConvert();
        HashMap<Integer, User> result = userConvert.process(list);        
        assertThat(result.get(0), is(list.get(0)));
    }
}
