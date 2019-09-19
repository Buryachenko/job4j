package ru.job4j.caсhe;

import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
/**
 *
 * @Test
 * @athor Oleg Buryachenko (mailto: ovburyachenko@yandex.ru)
 * @since 0.1
 * @version $Id$
 */
public class FileInputTest {

    @Test
    public void whenPutFileToCache() throws IOException {
        Cache cache = new Cache();
        cache.put(new FileBuffer("Address.txt"));
        String result = cache.read("Address.txt");
        assertThat(result, is("Rio de Janeiro."));
    }

    @Test
    public void whenNotPutFileToCache() throws IOException {
        Cache cache = new Cache();
        String result = cache.read("Address.txt");
        assertThat(result, is("Rio de Janeiro."));
    }
}