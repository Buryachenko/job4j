package ru.job4j.nonblocking;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class Caсhe {
    Map<Integer, SoftReference<Base>> map = new ConcurrentHashMap<>();
    public void add(Base model) {
        this.map.put(model.id(), new SoftReference<>(model));
    }

    public void update(Base model) {
        this.map.computeIfPresent(model.id(), (k,v) -> {
                    if (model.version() == Objects.requireNonNull(v.get()).version()) {
                        model.changeVersion();
                        return new SoftReference<>(model);
                    } else {
                        throw new RuntimeException("Not update!");
                    }
                }
        );
    }

    public void delete(Base model) {
        this.map.remove(model.id());
    }
}
