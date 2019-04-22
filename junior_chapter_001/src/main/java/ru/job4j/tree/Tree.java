package ru.job4j.tree;
import java.util.*;
/**
 *
 * Class Класс Tree
 * @athor Oleg Buryachenko
 * @since 20.04.19
 * @version 1
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;
    private int count = 0;

    public Tree(E parent) {
        this.root = new Node<>(parent);
        count++;
    }

    public boolean isBinary() {
        boolean result = true;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.leaves().size() > 2) {
                result = false;
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return result;
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        if (parent != null && child != null) {
                Optional<Node<E>> pFind = findBy(parent);
                Optional<Node<E>> cFind = findBy(child);
                if (pFind.isPresent() && cFind.isEmpty()) {
                    pFind.get().add(new Node<>(child));
                    count++;
                    result = true;
                }
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);
        return new Iterator<E>() {
            int modCount = count;
            Node<E> el;

            @Override
            public boolean hasNext() {
                if (modCount != count) {
                    throw new ConcurrentModificationException();
                }
                return !data.isEmpty();
            }

            @Override
            public E next() {
                    if (!hasNext()) {
                        throw new NullPointerException();
                    }
                    el = data.poll();
                    for (Node<E> child : el.leaves()) {
                        data.offer(child);
                    }
                return el.value();
            }
        };
    }
}