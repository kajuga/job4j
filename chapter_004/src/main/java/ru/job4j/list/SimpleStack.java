package ru.job4j.list;

/**
 * Realisation of collection - Stack.
 * @author Fedorov Aleksandr (msg2fedorov@gmail.com)
 * @param <T>
 */
public class SimpleStack<T> {
    /**
     * first - linked to first node in our stack.
     * modCount - checker of size our stack.
     */
    private Node<T> first;
    private int modCount;


    /**
     * method add a new element in stack as LIFO.
     * @param value
     */
    public void push(T value) {
        Node<T> newLink = new Node<>(value);
        newLink.next = this.first;
        this.first = newLink;
        countAdder();
    }

    /**
     * method extract last added element and remove it from stack.
     * @return
     */
    public T poll() {
        Node<T> result = this.first;
        first = first.next;
        countReduser();
        result.next = null;
        return result.date;
    }

    /**
     * Метод получения размера списка
     */
    public int getSize() {
        return this.modCount;
    }

    /**
     * Increase modCount.
     */
    private void countAdder() {
        modCount++;
    }

    /**
     * Decrease modCount.
     */
    private void countReduser() {
        modCount--;
    }

    /**
     * Node realisation.
     * @param <T>
     */
    private class Node<T> {
        T date;
        Node<T> next;

        public Node(T date) {
            this.date = date;
        }
    }
}
