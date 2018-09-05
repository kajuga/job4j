package ru.job4j.matrixiterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * EventIterator - итерируемся по четным числам массива.
 * @author Fedorov Aleksander (msg2fedorov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class EventIterator implements Iterator<Integer> {
    private int[] value;
    private int index = 0;

    public EventIterator(int[] value) {
        this.value = value;
    }

    /**
     * Проверяю, есть ли четное число в диапазоне <текущий индекс - конец массива>;
     * @return
     */
    @Override
    public boolean hasNext() {
        while (index < value.length && value[index] % 2 != 0) {
            index++;
        }
        return index < value.length;
    }

    /**
     * Перемещаюсь по элементам массива
     * @return
     */
    @Override
    public Integer next() {
        if (hasNext()) {
            Integer result = value[index++];
            return result;
        }
        throw new NoSuchElementException();
    }
}