package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.lang.*;

/**
 *
 * Class Класс добавляет и предоставляет личную информацию о пользователях.
 * @athor Buryachenko
 * @since 09.02.19
 * @version 1
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (var person : this.persons) {
            if (person.getName().contains(key) || person.getSurname().contains(key) || person.getAddress().contains(key) || person.getPhone().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }
}
