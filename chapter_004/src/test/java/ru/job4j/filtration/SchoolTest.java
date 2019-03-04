package ru.job4j.filtration;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import java.util.ArrayList;
import java.util.List;

/**
 * @Test
 * @athor Oleg Buryachenko (mailto: ovburyachenko@yandex.ru)
 * @since 0.1
 * @version $Id$
 */
public class SchoolTest {
    private List<Student> students = collectShool(0, 100);
    private School school = new School();

    public List<Student> collectShool(int start, int finish) {
        List<Student> students = new ArrayList<>();
        for (int i = start; i <= finish; i++) {
            students.add(new Student(i));
        }
        return students;
    }

    @Test
    public void whenCollectClass10A() {
        List<Student> result = school.collect(students, student -> student.getScore() >= 70 && student.getScore() <= 100);
        List<Student> expected = collectShool(70, 100);
        assertThat(result, is(expected));
    }

    @Test
    public void whenCollectClass10B() {
        List<Student> result = school.collect(students, student -> student.getScore() >= 50 && student.getScore() <= 70);
        List<Student> expected = collectShool(50, 70);
        assertThat(result, is(expected));
    }

    @Test
    public void whenCollectClass10V() {
        List<Student> result = school.collect(students, student -> student.getScore() >= 0 && student.getScore() <= 50);
        List<Student> expected = collectShool(0, 50);
        assertThat(result, is(expected));
    }
}
