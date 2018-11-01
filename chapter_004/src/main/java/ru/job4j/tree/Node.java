package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Node realisation.
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 */
public class Node<E extends Comparable<E>> {

    private final List<Node<E>> children = new ArrayList<>();
    private final E value;

    public Node(final E value) {
        this.value = value;
    }

    /**
     * add child to node.
     * @param child
     */
    public void add(Node<E> child) {
        this.children.add(child);
    }

    /**
     * get leaves from node lists.
     * @return
     */
    public List<Node<E>> leaves() {
        return this.children;
    }

    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }

    public E getValue() {
        return this.value;
    }
}