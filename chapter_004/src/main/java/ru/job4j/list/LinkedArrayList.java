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
     * Added a new element in dynamic LinkedArrayList
     * @param date - date
     */
    public void add(E date) {
        addLast(date);
    }

    /**
     * Метод addLast - добавляет в конец.
     * @param date элемент.
     */
    private void addLast(E date) {
        Node<E> lastNode = this.lastNode;
        Node<E> newNode = new Node<>(lastNode, date, null);
        this.lastNode = newNode;
        if (lastNode != null) {
            lastNode.next = newNode;
        } else {
            this.firstNode = newNode;
        }
        sizeAdder();
    }

    /**
     * Getting Node`s date from own dynamic LinkedArray structure
     */
    public E get(int index) {
        Node<E> result = this.firstNode;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    /**
     * Удаляет первый объект из списка.
     * @return удаляемый объект.
     */
    public E dropFirst() {
        E result = this.firstNode.date;
        if (modCount > 1) {
            this.firstNode.next.prev = null;
            this.firstNode = this.firstNode.next;
        } else {
            this.firstNode = null;
            this.lastNode = null;
        }
        sizeDecreaser();
        return result;
    }

    /**
     * Удаляет последний объект из списка.
     * @return удаляемый объект.
     */
    public E dropLast() {
        E result = this.lastNode.date;
        if (modCount > 1) {
            this.lastNode.prev.next = null;
            this.lastNode = this.lastNode.prev;
        } else {
            this.firstNode = null;
            this.lastNode = null;
        }
        sizeDecreaser();
        return result;
    }

    /**
     * Return current size of own dynamic LinkedArray structure
     * @return
     */
    public int getSize() {
        return this.modCount;
    }

    /**
     * increment variable madCount method
     */
    private void sizeAdder() {
        this.modCount++;
    }

    /**
     * decrement variable madCount method
     */
    private void sizeDecreaser() {
        this.modCount--;
    }

    /**
     * node realisation in own dynamic LinkedArray structure
     * @param <E> параметр определенный при создании класса
     */
     private static class Node<E> {
        E date;
        Node<E> prev;
        Node<E> next;

        private Node(Node<E> prev, E date, Node<E> next) {
            this.prev = prev;
            this.date = date;
            this.next = next;
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