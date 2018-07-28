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
        movePosition();
    }

    /**
     * Проверяю, есть ли четное число в диапазоне <текущий индекс - конец массива>;
     * @return
     */
    @Override
    public boolean hasNext() {
        /*boolean result = false;
        int counter = 0;
        for(int i = index; i < value.length; i++){
            if(value[i] % 2 == 0){
                counter++;
            }
            if (counter > 0){
                result = true;
                break;
            }
        }*/
        return index < value.length;
    }

    /**
     * Перемещаюсь по четным элементам массива
     * @return
     */
    @Override
    public Integer next() {
        if (hasNext()){
            Integer result = value[index++];
            movePosition();
            return result;
        } else  {
            throw new NoSuchElementException();
        }
    }

    private void movePosition() {
        while (index < value.length && value[index] % 2 != 0) {
            index++;
        }
    }
}