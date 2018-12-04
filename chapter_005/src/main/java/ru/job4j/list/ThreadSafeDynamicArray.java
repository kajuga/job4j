package ru.job4j.list;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import java.util.Iterator;

/**
 * Threadsafe dynamic array. with snapshoot.
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 * @param <E>
 */
@ThreadSafe
public class ThreadSafeDynamicArray<E> implements Iterable<E> {
    @GuardedBy("this")
    private DynamicArray<E> dynamicArray;

    public ThreadSafeDynamicArray(DynamicArray<E> dynamicArray) {
        this.dynamicArray = dynamicArray;
    }

    public synchronized boolean add(E e) {
        return this.dynamicArray.add(e);
    }

    public synchronized int size() {
        return this.dynamicArray.size();
    }

    public synchronized E get(int index) {
        return this.dynamicArray.get(index);
    }

    private DynamicArray<E> snapShot(DynamicArray<E> from) {
        DynamicArray<E> copy = new DynamicArray<>();
        for (int i = 0; i < from.size(); i++) {
            copy.add(from.get(i));
        }
        return copy;
    }

    @Override
    public synchronized Iterator<E> iterator() {
        return this.snapShot(dynamicArray).iterator();
    }
}