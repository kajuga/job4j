package ru.job4j.iteratorofiterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Класс-итератор, позволяющий пробегаться по содержимому передаваемых итераторов.
 * @author Fedorov Aleksander (msg2fedorov@gmail.com)
 * @version $Id$
 * @since 0.1
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