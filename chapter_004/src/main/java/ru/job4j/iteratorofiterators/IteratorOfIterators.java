package ru.job4j.iteratorofiterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Задача 5.1.4. Создать convert(Iterator<Iterator>)
 * Класс-итератор, позволяющий пробегаться по содержимому передаваемых итераторов.
 * @author Fedorov Aleksander (msg2fedorov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
class Converter {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        Iterator<Integer> converter = new Iterator <Integer>() {
            private Iterator<Iterator<Integer>> iterators;
            private Iterator<Integer> index;

            {
                iterators = it;
                if (it.hasNext()) {
                    index = it.next();
                }
            }

            @Override
            public boolean hasNext() {
                boolean hasNext = false;
                if (index != null) {
                    hasNext = index.hasNext();
                }
                while (!hasNext && iterators.hasNext()) {
                    index = iterators.next();
                    hasNext = index.hasNext();
                }
                return hasNext;
            }

            @Override
            public Integer next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    return index.next();
                }
            };
        return converter;
    }
}