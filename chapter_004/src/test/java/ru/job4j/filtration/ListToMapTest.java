package ru.job4j.filtration;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Test
 * @athor Oleg Buryachenko (mailto: ovburyachenko@yandex.ru)
 * @since 0.1
 * @version $Id$
 */
public class ListToMapTest {

    @Test
    public void whenListToMapStudent() {
        List<Student> extended = Arrays.asList(
                new Student("Ivanov"),
                new Student("Petrov"),
                new Student("Sidorov")
        );
        final Map<String, Student> mapStudent = extended.stream().distinct().collect(Collectors.toMap(
                Student::getSurname,
                student -> student
        ));
        List<Student> result = mapStudent.values().stream().collect(Collectors.toList());
        result.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        });
        assertThat(result, is(extended));
    }
}
