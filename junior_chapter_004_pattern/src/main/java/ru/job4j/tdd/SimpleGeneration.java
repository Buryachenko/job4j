package ru.job4j.tdd;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *  Class SimpleGeneration
 *  @author Buryachenko
 *  @since 03.09.2019
 *  @version 1
 */
public class SimpleGeneration implements Template {
    private final Pattern KEYS = Pattern.compile("\\$\\{.+?}");

    @Override
    public String generate(String template, Map<String, String> map) {
        Matcher matcher = this.KEYS.matcher(template);
        Set<String> set = new TreeSet<>();
        while (matcher.find()) {
            set.add(matcher.group());
        }
        if (set.size() < map.size()) {
            throw new NoSuchElementException("Extra key in map.");
        }
        return matcher.replaceAll(m -> map.get(template.substring(m.start() + 2, m.end() - 1)));
    }
}