package ru.job4j.set;

import ru.job4j.list.DynamicArray;
import java.util.Iterator;

/**
 * SimpleSet realisation.
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 * @param <E>
 */
public class SimpleSet<E> implements Iterable<E> {
    /**
     * Объект, используемый в качестве хранилища элементов Set`а.
     */
    private DynamicArray<E> storage = new DynamicArray<E>();

    /**
     * Добавление элемента в set, проверка на уникальность перед добавлением.
     * @param e
     */
    public boolean add(E e) {
        for (E content : this.storage) {
            if (e.equals(content)) {
                return false;
            }
        }
        storage.add(e);
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return this.storage.iterator();
    }
}