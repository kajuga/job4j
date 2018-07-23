package ru.job4j.matrixiterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EventIterator implements Iterator<Integer> {
    private int[] value;
    private int index = 0;

    public EventIterator(int[] value) {
        this.value = value;
        movePosition();
    }

    @Override
    public boolean hasNext() {
        return value.length > index;
    }

    @Override
    public Integer next() {
        try {
            Integer result = value[index++];
            movePosition();
            return result;
        }catch (IndexOutOfBoundsException e){
            throw new NoSuchElementException();
        }
    }

    private void movePosition(){
        while (index < value.length && value[index] %2 != 0){
            index++;
        }
    }
}
