package ru.job4j.matrixiterator;

import java.util.Iterator;

public class MatrixIterator implements Iterator<Integer> {
    private int[] value;
    private int index = 0;


    public MatrixIterator(int[] value) {
        this.value = value;
    }

    @Override
    public boolean hasNext() {
        return value.length > index;
    }

    @Override
    public Integer next() {
        return value[index++];
    }
}