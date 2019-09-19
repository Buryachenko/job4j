package ru.job4j.caсhe;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * Class FileBuffer
 * @athor Buryachenko
 * @since 20.09.19
 * @version 1
 */
public class FileBuffer implements Buffer {

    private final String fileName;
    private final String buffer;

    public FileBuffer(String fileName) throws IOException {
        this.fileName = fileName;
        this.buffer = write(fileName);
    }

    public String fileName() {
        return this.fileName;
    }

    @Override
    public String write(String fileName) throws IOException {
        FileInputStream stream = new FileInputStream(fileName);
        return new String(stream.readAllBytes());
    }

    @Override
    public String read() {
        return this.buffer;
    }
}
