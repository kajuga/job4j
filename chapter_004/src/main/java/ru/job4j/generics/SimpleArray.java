package ru.job4j.generics;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Fedorov Aleksander (msg2fedorov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleArray<T> implements Iterable<T> {
    private Object[] model = new Object[10];
    private int index;

    public void add(T model) {
        try {
            this.model[index++] = model;
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
    }

    public void set(int index, T model) {
        this.model[index] = model;
    }

    public void delete(int index) {
        System.arraycopy(model, index + 1, model, index, model.length - 1 - index);
        model[model.length - 1] = null;
    }

    public T get(int index) {
        return (T)this.model[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current;

            @Override
            public boolean hasNext() {
                return model.length > current;
            }

            @Override
            public T next() {
                return (T)model[current++];
            }
        };
    }
}