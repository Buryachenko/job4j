package ru.job4j.filtration;

import java.util.Objects;

/**
 *
 * Class Класс описывает действия ученика
 * @athor Buryachenko
 * @since 04.03.19
 * @version 1
 */
public class Student {
    private int score;
    private String surname;

    public Student(String surname) {
        this.surname = surname;
    }

    public Student(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

    public  String getSurname() {
        return this.surname;
    }
   @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.score, other.score)) {
           return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.score);
        hash = 47 * hash + Objects.hashCode(this.surname);
        return hash;
    }
}
