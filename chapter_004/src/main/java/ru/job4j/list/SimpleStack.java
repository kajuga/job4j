package ru.job4j.list;

/**
 * Realisation of collection - Stack.
 * @author Fedorov Aleksandr (msg2fedorov@gmail.com)
 * @param <T>
 */
public class SimpleStack<T> {
    private LinkedArrayList<T> storage = new LinkedArrayList<>();

    /**
     * Удаляет последний элемент из очереди.
     * @return удаленный элемент из головы очереди.
     */
    public T poll() {
        return storage.dropLast();
    }

    /**
     * Вводит элемент в очередь.
     * @param value элемент.
     */
    public void push(T value) {
        storage.add(value);
    }
}