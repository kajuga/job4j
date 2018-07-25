package ru.job4j.iteratorofiterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * вот эту куевину нужно реализовать - класс Converter с методом convert
 * 1. должен принимать итератор
 */
class Converter implements Iterator<Integer> {
    private Iterator[] iterators;
    private int index = 0;


    @Override
    public boolean hasNext() {
        boolean hasNext = false;

        while (iterators != null && index < iterators.length) {
            hasNext = iterators[index].hasNext();
            if (!hasNext) {
                index++;
            } else {
                break;
            }
        }
        return hasNext;
    }

    @Override
    public Integer next() {

        try {
            if (iterators[index].hasNext()) {
                return (Integer) iterators[index].next();
            } else {
                return (Integer) iterators[++index].next();
            }
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
    }

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        List<Iterator<Integer>> list = new ArrayList<>();
        while (it.hasNext()) {
            list.add(it.next());
        }
        Converter converter = new Converter();
        converter.iterators = list.toArray(new Iterator[list.size()]);
        return converter;
    }
}