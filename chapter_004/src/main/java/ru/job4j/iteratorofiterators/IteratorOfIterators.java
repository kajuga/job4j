package ru.job4j.iteratorofiterators;

import java.util.Iterator;


/**
 * Реализовать класс с методом Iterator<Integer> convert(Iterator<Iterator<Integer>> it).
 */

public class IteratorOfIterators <T extends Number, I extends Iterator<T>> implements Iterator {

    private final I[] iterators;
    private int index = 0;

    public IteratorOfIterators(I[] iterators) {
        this.iterators = iterators;
    }

    @Override
    public boolean hasNext() {
        return iterators[index].hasNext() || notDetectedLastIterator();
    }

    private boolean notDetectedLastIterator() {
        return (index + 1 < iterators.length);
    }

    @Override
    public T next() {
        if (iterators[index].hasNext()) {
            return iterators[index].next();
        } else {
            return iterators[++index].next();
        }
    }
}

    class Converter {


        Iterator<Integer> convert(Iterator<Iterator<Integer>> it){

            return null;
        }
    }


    class SimpleIterator<T extends Number> implements Iterator {
        private final T[] values;
        private int index = 0;

        public SimpleIterator(final T[] values) {
            this.values = values;
        }

        @Override
        public boolean hasNext() {
            return index < values.length;
        }

        @Override
        public T next() {
            return values[index++];
        }
    }

    class Client4 {
        public static void main(String[] args) {
            SimpleIterator <Integer> i1 = new SimpleIterator <>(new Integer[]{1, 2, 3});
            SimpleIterator <Integer> i2 = new SimpleIterator <>(new Integer[]{1, 2, 3, 4});

            IteratorOfIterators <Integer, Iterator <Integer>> itr = new IteratorOfIterators <>(new SimpleIterator[]{i1, i2});
            while (itr.hasNext()) {
                Integer i = itr.next();
                System.out.println(i);
            }
        }
    }





