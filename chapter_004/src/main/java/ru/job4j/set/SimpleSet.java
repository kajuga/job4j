package ru.job4j.set;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSet<E> implements Iterable<E> {
    private E[] values;
    private int counter;


    /**
     * Конструктор коллекции.
     */
    SimpleSet() {
        this.values = (E[]) (new Object[16]);
    }

    /**
     * Добавление элемента в коллекцию.
     * @param e
     */
    public boolean add (E e) {
        boolean result = false;
        E[] temp = values;
        if (counter >= values.length) {
            values = (E[]) new Object[temp.length * 2];
            System.arraycopy(temp, 0, values, 0, temp.length);
        }
        if(!uniqueChecker(e)) {
            values[counter] = e;
            fillChecker(counter);
            result = true;
        }
        return result;
    }

    private void fillChecker(int counter) {
        this.counter++;
    }

    /**
     * Проверка уникальности элемента перед добавлением в коллекцию.
      * @param e
     * @return
     */
    boolean uniqueChecker(E e) {
            boolean result = false;
            for (int i = 0; i < this.values.length; i++) {
                if (this.values[i].equals(e)) {
                    result = true;
                }
            }
            return result;
        }

    boolean uniqueChecker2(E e) {
        boolean result = false;
        for (int i = 0; i < this.values.length; i++) {
            if (this.values[i] == e) {
                result = true;
            }
        }
        return result;
    }

    /**
     * получение размера "множества"
     * @return
     */
    public int getSize() {
        return this.counter;
    }


    @Override
    public Iterator<E> iterator() {
        return new SimpleSetIterator<E>(values, counter);
    }

    class SimpleSetIterator<E> implements Iterator<E> {
        private int index = 0;
        private E[] values;
        private int expectedCount;

    public SimpleSetIterator(E[] values, int expextedCount) {
        this.expectedCount = expectedCount;
        this.values = values;
    }

        @Override
        public boolean hasNext() {
            if (expectedCount != counter) {
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
