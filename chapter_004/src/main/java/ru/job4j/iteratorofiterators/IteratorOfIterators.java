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
    private Iterator<Iterator<Integer>> iterators;
    private Iterator<Integer> index;

    @Override
    public boolean hasNext() {
        boolean hasNext = false;
        if (index != null) {
            hasNext = index.hasNext();
        }
        while (!hasNext && iterators.hasNext()){
            index = iterators.next();
            hasNext = index.hasNext();
        }
        return hasNext;
    }

    @Override
    public Integer next() {
            if(hasNext()) {
                return index.next();
            } else {
                throw new NoSuchElementException();
            }
    }

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        Converter converter = new Converter();
        converter.iterators = it;
        if (it.hasNext()) {
            converter.index = it.next();
        }
        return converter;
    }
}