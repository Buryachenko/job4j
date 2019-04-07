package ru.job4j.generic;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;
/**
 *
 * @Test
 * @athor Oleg Buryachenko (mailto: ovburyachenko@yandex.ru)
 * @since 0.1
 * @version $Id$
 */
public class UserStoreTest {
    UserStore userStore;
    RoleStore roleStore;
    int size = 10;

    @Before
    public void init() {
        userStore = new UserStore(size);
        roleStore = new RoleStore(size);
        for (int i = 0; i < size; i++) {
            userStore.add(new User("test" + i));
            roleStore.add(new Role("test" + i));
        }
    }
    @Test
    public void whenUserStoreReplaceElement() {
        userStore.replace("test1", new User("replace"));
        User user = userStore.findById("replace");
        assertThat(user.getId(), is("replace"));
    }

    @Test(expected = NullPointerException.class)
    public void whenUserStoreDeleteElement() {
        User user = userStore.findById("test1");
        assertThat(user.getId(), is("test1"));
        userStore.delete("test1");
        userStore.findById("test1").getId();
    }

    @Test
    public void whenRoleStoreReplaceElement() {
        roleStore.replace("test1", new Role("replace"));
        Role role = roleStore.findById("replace");
        assertThat(role.getId(), is("replace"));
    }

    @Test(expected = NullPointerException.class)
    public void whenRoleStoreDeleteElement() {
        Role role = roleStore.findById("test1");
        assertThat(role.getId(), is("test1"));
        roleStore.delete("test1");
        roleStore.findById("test1").getId();
    }
}