package ru.job4j.sqlite;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class Entry {
    private Integer field;

    public Entry() {

    }

    public Entry(Integer field) {
        this.field = field;
    }

    @XmlElement
    public int getField() {
        return this.field;
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
        final Entry other = (Entry) obj;
        if (!Objects.equals(this.field, other.field)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.field);
        return hash;
    }
}
