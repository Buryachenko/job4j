package ru.job4j.nonblocking;

import org.junit.Test;
import java.util.concurrent.atomic.AtomicReference;

public class CaсheTest {
    private class ThreadChange extends Thread {
        private final Base model;
        private final Caсhe caсhe;
        private final AtomicReference ex;
        public ThreadChange(Base model, Caсhe caсhe, AtomicReference ex) {
            this.model = model;
            this.caсhe = caсhe;
            this.ex = ex;
        }
        @Override
        public void run() {
            this.model.setData(Thread.currentThread().getName());
            try {
                this.caсhe.update(this.model);
            } catch (Exception e) {
                ex.set(e);
            }
        }
    }

    @Test
    public void whenUpdateModelOfThreadTwo() throws InterruptedException {
        AtomicReference<Exception> ex = new AtomicReference<>();
        Base model = new Base(0, "General");
        Caсhe caсhe = new Caсhe();
        caсhe.add(model);
        ThreadChange first = new ThreadChange(model, caсhe, ex);
        ThreadChange second = new ThreadChange(model, caсhe, ex);
        first.start();
        second.start();
        first.join();
        second.join();
    }
}