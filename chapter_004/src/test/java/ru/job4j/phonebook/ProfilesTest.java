package ru.job4j.phonebook;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
/**
 * @Test
 * @author Oleg Buryachenko (mailto: ovburyachenko@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ProfilesTest {
    @Test
    public void whenGetAddressProfiles() {
        List<Address> expected = Arrays.asList(
            new Address("Novosibirsk", "Cheluskincev", 28, 3),
            new Address("Yekaterinburg", "Stroiteley", 55, 10),
            new Address("Moskow", "Kosmonavtov", 39, 118)
        );
        List<Profile> profiles = new ArrayList();
        expected.forEach(addr -> profiles.add(new Profile(addr)));
        List<Address> result = new Profiles().collect(profiles);
        assertThat(expected, is(result));
    }

    @Test
    public void whenGetUniqAddressAndSortOfCity() {
        List<Address> expected = new LinkedList(Arrays.asList(
                new Address("Novosibirsk", "Cheluskincev", 28, 3),
                new Address("Moskow", "Kosmonavtov", 39, 118),
                new Address("Moskow", "Kosmonavtov", 39, 118),
                new Address("Yekaterinburg", "Stroiteley", 55, 10)
        ));
        List<Profile> profiles = new ArrayList();
        expected.forEach(addr -> profiles.add(new Profile(addr)));
        List<Address> result = new Profiles().sortAddress(profiles);
        expected.remove(1);
        expected.set(1, expected.set(0, expected.get(1)));
        assertThat(expected, is(result));
    }
}