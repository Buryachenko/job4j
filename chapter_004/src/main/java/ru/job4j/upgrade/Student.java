package ru.job4j.upgrade;
import java.util.Comparator;
import java.util.Objects;

public class Student implements Comparator<Student> {
    private String name;
    private int scope;
    public  Student() {

    }

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    public String getName() {
        return this.name;
    }

    public int getScope() {
        return this.scope;
    }

    @Override
    public int compare(Student o1, Student o2) {
        int result = 0;
        if (o1 != null && o2 != null) {
            result = -1 * Integer.compare(o1.scope, o2.scope);
        }
        if (o1 == null && o2 != null) {
            result = -1 * Integer.compare(-1, o2.scope);
        }
        if (o1 != null && o2 == null) {
            result = -1 * Integer.compare(o1.scope, -1);
        }
        return result;
    }
    @Override
    public String toString() {
        return String.format("[name = %s, scope = %d]", this.name, this.scope);
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
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.scope, other.scope)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.scope);
        hash = 47 * hash + Objects.hashCode(this.scope);
        return hash;
    }
}

