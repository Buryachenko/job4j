package ru.job4j.bank;
import java.util.Objects;

/**
 *
 * Class Класс предоставляет данные User
 * @athor Buryachenko
 * @since 26.02.2019
 * @version 1
 */
public class User {
    private String name;
    private String passport;
    
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }
    
    public String getName() {
        return this.name;
    }

    public String getPassport() {
        return this.passport;
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
        final User other = (User) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.passport, other.passport)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.passport);
        return hash;
    }
}
