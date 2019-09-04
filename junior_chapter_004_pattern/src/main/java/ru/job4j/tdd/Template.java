package ru.job4j.tdd;

import java.util.Map;

/**
 * Hello world, ${name}
 * @param temlate
 * @param data
 * @return
 */
public interface Template {
    String generate(String template, Map<String, String> map) throws Exception;
}
