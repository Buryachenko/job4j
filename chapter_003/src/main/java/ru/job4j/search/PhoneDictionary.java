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
    private List<Person> persons = new ArrayList<Person>();

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
        for (Person person : this.persons) {
            int numFild = 0;
            switch (numFild) {
                case 0:
                    if ((person.getName().contains(key))) {
                        result.add(person);
                    } else {
                        numFild++;
                    }
                case 1:
                    if ((person.getSurname().contains(key))) {
                        result.add(person);
                    } else {
                        numFild++;
                    }
                case 2:
                    if ((person.getAddress().contains(key))) {
                        result.add(person);
                    } else {
                        numFild++;
                    }
                case 3:
                    if ((person.getPhone().contains(key))) {
                        result.add(person);
                    } else {
                        break;
                    }
                default: break;
            }
        }
        return result;
    }
}
