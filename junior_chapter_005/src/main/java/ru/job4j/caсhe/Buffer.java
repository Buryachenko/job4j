package ru.job4j.caсhe;

import java.io.IOException;

public interface Buffer {
    String write(String fileName) throws IOException;
    String read();
}
