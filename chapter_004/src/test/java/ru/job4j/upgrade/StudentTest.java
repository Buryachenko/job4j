package ru.job4j.upgrade;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 *
 * @Test Тест метода levelOf, который должен вернуть список студентов у которых балл аттестата больше bound.
 * @author Oleg Buryachenko (mailto: ovburyachenko@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class StudentTest {
    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .sorted(new Student())
                .flatMap(Stream::ofNullable)
                .takeWhile(student -> student.getScope() > bound).collect(Collectors.toList());
    }

    @Test
    public void whenStudentsIsSortedAndFilterNullAndLevelOfBound() {
        List<Student> students = Arrays.asList(
                                                null,
                                                new Student("Sidorov", 5),
                                                null,
                                                new Student("Ivanov", 3),
                                                null,
                                                new Student("Petrov", 4),
                                                null);
        List<Student> result = levelOf(students, 4);
        assertThat(Collections.singletonList(new Student("Sidorov", 5)), is(result));
    }
}
