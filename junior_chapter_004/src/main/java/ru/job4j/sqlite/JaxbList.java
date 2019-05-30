package ru.job4j.sqlite;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="entries")
@XmlAccessorType(XmlAccessType.FIELD)
public class JaxbList<T> {
    protected List<T> entry;

    public JaxbList(){}

    public JaxbList(List<T> entries){
        this.entry = entries;
    }

    public List<T> getList(){
        return this.entry;
    }
}
