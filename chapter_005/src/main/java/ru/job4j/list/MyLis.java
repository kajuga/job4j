package ru.job4j.list;

public class MyLis<E> {

    private DynamicArray<E> dynamicArray = new DynamicArray<>();

    public synchronized boolean add(E e) {
        return dynamicArray.add(e);
    }
}
