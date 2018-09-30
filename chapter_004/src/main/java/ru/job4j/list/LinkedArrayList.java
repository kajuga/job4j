package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Fedorov Aleksandr (msg2fedorov@gmail.com)
 * @param <E>
 * Реализация динамического контейнера на основе связного списка
 */
public class LinkedArrayList<E> implements Iterable {
    private Node<E> firstNode;
    private Node<E> lastNode;
    private int modCount;

    /**
     * Added a new element in own dynamic LinkedArrayList
     * @param value - date
     */
    public void add(E value) {
        Node<E> newLink = new Node<>(value);
        if (firstNode != null) {
            lastNode.next = newLink;
        } else {
            firstNode = newLink;
        }
        lastNode = newLink;
        sizeAdder(modCount);
    }

    /**
     * Returns current size of own dynamic LinkedArray structure
     * @return
     */
    public int getSize() {
        return this.modCount;
    }

    /**
     * increment variable madCount method
     * @param size
     */
    private void sizeAdder(int size) {
        this.modCount++;
    }

    /**
     * Getting element from own dynamic LinkedArray structure
     */
    public E get(int index) {
        Node<E> result = this.firstNode;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    /**
     * node realisation in own dynamic LinkedArray structure
     * @param <E>
     */
     private class Node<E> {
        E date;
        Node<E> next;
//        not this time
//        Node<E> previous;

        private Node(E date) {
            this.date = date;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedArrayIterator<>(firstNode, modCount);
    }

    /**
     * Realisation of Iterator for own dynamic LinkedArray structure
     */
    private class LinkedArrayIterator<E> implements Iterator<E> {
        private Node<E> current;
        private int expectedModCount;

        private LinkedArrayIterator(Node<E> values, int expectedModCount) {
            this.expectedModCount = expectedModCount;
            this.current = values;
        }

        @Override
        public boolean hasNext() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return current != null && current.next != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E res = current.next.date;
            current = current.next;
            return res;
        }
    }
}
