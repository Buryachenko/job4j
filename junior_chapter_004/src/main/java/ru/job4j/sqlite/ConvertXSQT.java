package ru.job4j.sqlite;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.util.*;
import java.io.*;

/**
 *
 * Class ConvertXSQT
 * @athor Buryachenko
 * @since 31.05.19
 * @version 1
 */

public class ConvertXSQT extends DefaultHandler {
    private Hashtable tags;
    private int sum;

    public void startDocument() throws SAXException {
        tags = new Hashtable();
    }

    public void startElement(String namespaceURI,
                             String localName,
                             String qName,
                             Attributes atts) throws SAXException {
        String key = localName;
        Object value = tags.get(key);
        if (value == null) {
            tags.put(key, new Integer(1));
        }
        else {
            int count = ((Integer)value).intValue();
            count++;
            this.sum = this.sum + ((Integer)value).intValue();
            tags.put(key, new Integer(count));
        }
    }

    public void endDocument() throws SAXException {
        Enumeration e = tags.keys();
        while (e.hasMoreElements()) {
            String tag = (String)e.nextElement();
            int count = ((Integer)tags.get(tag)).intValue();
            System.out.println(String.format("%s%s%s %s %s","Local Name \"", tag, "\" occurs ", count, " times"));
        }
        System.out.println(String.format("%s %d", "Summa all field = ", sum));
    }

    public static void main (String args[]) throws TransformerException, ParserConfigurationException, SAXException, IOException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(
                new StreamSource(
                        new FileInputStream("junior_chapter_004/sqlite/xsl/template.xsl"))
        );
        transformer.transform(new StreamSource(
                new FileInputStream("junior_chapter_004/sqlite/xml/entry.xml")),
                new StreamResult(new FileOutputStream("junior_chapter_004/sqlite/xml/result.xml"))
        );
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        SAXParser saxParser = spf.newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();
        xmlReader.setContentHandler(new ConvertXSQT());
        xmlReader.parse("junior_chapter_004/sqlite/xml/result.xml");
    }
}
