package ru.job4j.caсhe;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * Class Cache
 * @athor Buryachenko
 * @since 20.09.19
 * @version 1
 */
public class Cache {
    private Map<String, SoftReference<Buffer>> map = new HashMap<>();

    public void put(FileBuffer buffer) {
        this.map.put(buffer.fileName(), new SoftReference<>(buffer));
    }

    public String read(String fileName) throws IOException {
        FileBuffer buffer = get(fileName);
        if (buffer == null) {
            buffer = new FileBuffer(fileName);
            put(buffer);
        }
        return buffer.read();
    }

    private FileBuffer get(String fileName) {
        FileBuffer buffer = null;
        if (this.map.keySet().stream().anyMatch(key-> key.equals(fileName))) {
            SoftReference ref = this.map.get(fileName);
            buffer = (FileBuffer) ref.get();
            if (buffer == null) {
                this.map.remove(fileName);
            }
        }
        return buffer;
    }
}
