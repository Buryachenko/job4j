package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.StringJoiner;
/**
 *
 * Class Класс Config
 * @athor Oleg Buryachenko
 * @since 20.04.19
 * @version 1
 */
public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        Properties prop = new Properties() {
            public Object put(Object key, Object value) {
                values.put((String) key, (String) value);
                return null;
            }
        };
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            prop.load(read);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}