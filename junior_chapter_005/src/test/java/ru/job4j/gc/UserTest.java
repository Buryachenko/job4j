package ru.job4j.gc;
import org.junit.Test;

public class UserTest {

    @Test
    public void whenCreatingGivenValueObjectTypeUser() throws InterruptedException {
        int size = 1000;
        User[] users = new User[size];
        for (int i = 0; i < size; i++) {
            users[i] = new User(Integer.toString(i));
        }
        for (int i = 0; i < size; i++) {
            users[i] = null;
        }
        Thread.sleep(1000);
    }

    @Test
    public void whenMemoryTestExample() {
        Runtime runtime = Runtime.getRuntime();
        User[] users = new User[1000];
        System.out.println(String.format("%-40s %20d", "Всего памяти:", runtime.totalMemory()));
        long mem1 = runtime.freeMemory();
        System.out.println(String.format("%-40s %20d", "Свободной памяти исходно:", mem1));
        runtime.gc();
        mem1 = runtime.freeMemory();
        System.out.println(String.format("%-40s %20d", "Свободной памяти после очистки:", mem1));
        for(int i = 0; i < 1000; i++) {
            users[i] = new User(Integer.toString(i));
        }
        long mem2 = runtime.freeMemory();
        System.out.println(String.format("%-40s %20d", "Свободной памяти после выделения:", mem2));
        System.out.println(String.format("%-40s %20d","Использовано памяти для выделения:", (mem1 - mem2)));
        for (int i = 0; i < 1000; i++) {
            users[i] = null;
        }
        runtime.gc();
        mem2 = runtime.freeMemory();
        System.out.println(String.format("%-40s %20d","Свободной памяти после очистки:", mem2));
    }
}