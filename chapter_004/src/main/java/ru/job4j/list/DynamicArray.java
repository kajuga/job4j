package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/** Реализация динамически расширяющегося контейнера
 * @author Fedorov Aleksander (msg2fedorov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class DynamicArray<E> implements Iterable<E> {
    private E[] values;
    private int modCount;

    DynamicArray() {
        values = (E[]) new Object[0];
    }

    /**
     * Добавление элемента
     * @param e
     * @return
     */
    public boolean add(E e) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = e;
            modCount++;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * Получение элемента по индексу
     * @param index
     * @return
     */
    public E get(int index) {
        return values[index];
    }

    /**
     * Получение размера контейнера
     * @return
     */
    public int size() {
        return values.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new DynamicArrayIterator<>(values, modCount);
    }

    /**
     * Итератор для контейнера
     */
    private class DynamicArrayIterator<E> implements Iterator<E> {
        private int index = 0;
        private E[]values;
        private int expectedModCount;

        public DynamicArrayIterator(E[] values, int expectedModCount) {
            this.expectedModCount = expectedModCount;
            this.values = values;
        }

        @Override
        public boolean hasNext() {
            return index < values.length;
        }

        @Override
        public E next() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return values[index++];
        }
    }
}