package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/** Реализация динамически расширяющегося контейнера
 * @author Fedorov Aleksander (msg2fedorov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class DynamicArray<E> implements Iterable<E> {
    private E[] values;
    private int modCount;

    public DynamicArray() {
        values = (E[]) new Object[16];
    }

    /**
     * Добавление элемента
     * @param e
     * @return
     */
    public boolean add(E e) {
        E[] temp = values;
        if (modCount >= values.length) {
            values = (E[]) new Object[temp.length * 2];
            System.arraycopy(temp, 0, values, 0, temp.length);
        }
        values[modCount] = e;
        modCountAdder(modCount);
        return true;
    }

    /**
     * Optimisation for modCount location after comment on my first variant.
     * @param modCount
     */
    private void modCountAdder(int modCount) {
        this.modCount++;
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
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return index < values.length;

        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return values[index++];
        }
    }
}