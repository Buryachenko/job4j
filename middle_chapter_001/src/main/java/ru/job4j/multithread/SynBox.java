package ru.job4j.multithread;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.list.Box;
import java.util.Iterator;
/**
 * Class Synbox is wrapper Box
 * @author Buryachenko
 * @version 1
 * @since 08.10.2019
 */
@ThreadSafe
public class SynBox<E> implements Iterable<E> {
    @GuardedBy("this")
    private final Box<E> box = new Box<>();

    @Override
    public synchronized Iterator<E> iterator() {
        return copy(this.box).iterator();
    }

    private Box copy(Box<E> box) {
        Box<E> boxCopy = new Box<>();
        for (E e : box) {
            boxCopy.add(e);
        }
        return boxCopy;
    }

    public synchronized void add(E data) {
        this.box.add(data);
    }

    public synchronized E get(int index) {
        return this.box.get(index);
    }
}
