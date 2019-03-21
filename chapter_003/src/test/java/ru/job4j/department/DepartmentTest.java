package ru.job4j.department;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Test. Отсортировать департаменты.
 * @author Oleg Buryachenko (mailto:ovburyachenko@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class DepartmentTest {
    private String[] departments = {
                                    "K1/SK1",
                                    "K1/SK1",
                                    "K1/SK2",
                                    "K1/SK1/SSK1",
                                    "K1/SK1/SSK1",
                                    "K1/SK1/SSK2",
                                    "K2",
                                    "K2",
                                    "K2/SK1/SSK1",
                                    "K2/SK1/SSK2"};

    @Test
    public void whenSortDepartmentIsRising() {       
        String[] expected = {
                                    "K1",
                                    "K1/SK1",
                                    "K1/SK2",
                                    "K1/SK1/SSK1",
                                    "K1/SK1/SSK2",
                                    "K2",
                                    "K2/SK1",
                                    "K2/SK1/SSK1",
                                    "K2/SK1/SSK2"};
        Department department = new Department(departments);
        String[] result = department.sortRising();
        assertThat(result, is(expected));
    }
    @Test
    public void whenSortDepartmentIsFalling() {       
        String[] expected = {
                                    "K2",
                                    "K2/SK1",
                                    "K2/SK1/SSK2",
                                    "K2/SK1/SSK1",
                                    "K1",
                                    "K1/SK2",
                                    "K1/SK1",
                                    "K1/SK1/SSK2",
                                    "K1/SK1/SSK1"};
        Department department = new Department(departments);
        String[] result = department.sortFalling();
        assertThat(result, is(expected));
    }
    @Test
    public void whenRemoveDuplicate() {
        String[] expected = {
                                    "K1/SK1",
                                    "K1/SK2",
                                    "K1/SK1/SSK1",
                                    "K1/SK1/SSK2",
                                    "K2",
                                    "K2/SK1/SSK1",
                                    "K2/SK1/SSK2"};
        Department department = new Department(departments);
        String[] result = department.removeDuplicate(departments);
        assertThat(result, is(expected));
    }
}