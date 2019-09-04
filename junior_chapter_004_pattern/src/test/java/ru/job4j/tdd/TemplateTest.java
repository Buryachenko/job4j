package ru.job4j.tdd;

import org.junit.Test;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class TemplateTest {
    @Test
    public void whenReplaceNameAndSubject() throws Exception {
        Template template = new SimpleGeneration();
        String text = "I am a ${name}, Who are ${subject}?";
        String checked = "I am a Ivan, Who are you?";
        String result = template.generate(text, Map.of("name", "Ivan", "subject", "you"));
        assertThat(result, is(checked));
    }

    @Test
    public void whenReplaceAllSos() throws Exception {
        Template template = new SimpleGeneration();
        String text = "Help, ${sos}, ${sos}, ${sos}";
        String checked = "Help, Aaaa, Aaaa, Aaaa";
        String result = template.generate(text, Map.of("sos", "Aaaa"));
        assertThat(result, is(checked));
    }

    @Test(expected = NullPointerException.class)
    public void whenNoKeyInMap() throws Exception {
        Template template = new SimpleGeneration();
        String text = "I am a ${name}, Who are ${subject}?";
        template.generate(text, Map.of("name", "Ivan"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenExcessKeyInMap() throws Exception {
        Template template = new SimpleGeneration();
        String text = "I am a ${name}, Who are ${subject}?";
        template.generate(text, Map.of("name", "Ivan", "subject", "you", "excess", "!!!"));
    }
}