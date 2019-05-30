package ru.job4j.sqlite;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

/**
 *
 * Class StoreXML
 * @athor Buryachenko
 * @since 31.05.19
 * @version 1
 */

public class StoreXML {
    private File target;

    public StoreXML() {

    }

    public StoreXML(File target) {
        this.target = target;
    }

    public void save(List<Entry> entries) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(JaxbList.class, Entry.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(
                    new JaxbList<>(entries),
                    new FileOutputStream(this.target)
            );
    }
}
