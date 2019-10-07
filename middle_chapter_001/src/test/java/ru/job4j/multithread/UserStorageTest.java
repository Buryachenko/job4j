package ru.job4j.multithread;

import static org.hamcrest.core.Is.is;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserStorageTest {
    @Test
    public void whenFromId1ToId2Transfer50() {
        UserStorage storage = new UserStorage();
        storage.add(new User(1, 100));
        storage.add(new User(2, 100));
        storage.transfer(1, 2, 50);
        assertThat(storage.get(1).amount(), is(50));
        assertThat(storage.get(2).amount(), is(150));
    }
}