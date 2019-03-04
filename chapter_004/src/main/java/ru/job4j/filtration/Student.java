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

    public Student() {

    }

    public Student(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
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
        if (!Objects.equals(this.score, other.score)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.score);
        return hash;
    }
}
