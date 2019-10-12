package ru.job4j.multithread;


public class ParallelSearch {

    public static void main(String[] args) {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<Integer>(1000);
        final Thread consumer = new Thread (
                () -> {
                    while (!Thread.currentThread().isInterrupted()) {
                        try {
                            System.out.println(queue.poll());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                        }
                    }
                }
        );

        consumer.start();

        Thread producer = new Thread (
                () -> {
                    for (int index = 0; index != 3; index++) {
                        try {
                            queue.offer(index);
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

        );

        producer.start();

        final Thread check = new Thread (
                () -> {
                    while (producer.isAlive() || queue.size() != 0) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            consumer.interrupt();
                        }
                    }
                    while (consumer.isAlive()) {
                        consumer.interrupt();
                    }
                }
        );
        check.start();
    }

}