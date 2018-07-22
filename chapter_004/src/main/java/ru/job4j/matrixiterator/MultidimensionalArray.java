package ru.job4j.matrixiterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MultidimensionalArray implements Iterable <Integer> {
    private int[][] value;

    public MultidimensionalArray(int[][] value) {
        this.value = value;
    }

    @Override
    public Iterator iterator() {
        Iterator it = new Iterator() {
            private int indexRow = 0;
            private int indexColumn = 0;

            @Override
            public boolean hasNext() {
                return indexRow < value.length && indexColumn < value[indexRow].length;
            }

            @Override
            public Integer next() {
                try {
                    Integer result = value[indexRow][indexColumn];
                    if (indexColumn < value[indexRow].length) {
                        indexColumn++;
                    }

                    if (indexColumn == value[indexRow].length) {
                        indexColumn = 0;
                        indexRow++;
                    }

                    return result;
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new NoSuchElementException();
                }
            }
        };
        return it;
    }
}