package ru.job4j.filtration;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * Class Класс предоставляет список учеников
 * @athor Buryachenko
 * @since 04.03.19
 * @version 1
 */
public class School {
    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        List<Student> result = students.stream().filter(predict).collect(Collectors.toList());
        return result;
    }
}
