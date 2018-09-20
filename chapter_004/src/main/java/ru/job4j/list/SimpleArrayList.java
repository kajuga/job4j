package ru.job4j.list;

/**
 * @author Fedorov Alrksander (msg2fedorov@gmail.com)
 * @version #IdS
 * @since 0.1
 */
public class SimpleArrayList<E> {
    private int size;
    private Node<E> first;

    /**
    * Метод вставляет данные в начало списка
    */
    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Удаление первого элемента списка (может boolean сделать... не знаю)
     */
    public E delete() {
        Node<E> deleted = this.first;
        this.first = deleted.next;
        deleted.next = null;
        this.size--;
        return deleted.date;
    }

    /**
     * Метод получения элемента по индексу
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    /**
     * Метод получения размера списка
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Set List size
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Класс предназначен для хранения данных и хранения ссылки (Node<E> next) на следующий экземпляр
     * @param <E>
     */
    private class Node<E> {
        E date;
        Node<E> next;

        public Node(E date) {
            this.date = date;
        }
    }
}