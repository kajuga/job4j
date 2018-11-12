package ru.job4j.tree;

import java.util.*;

/**
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 * Simple Tree realisation/
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;
    private int modCount = 0;
    private int size;

    public Tree(E root) {
        this.root = new Node<>(root);
        this.size++;
    }

    public int getSize() {
        return this.size;
    }

    /**
     * add child to parent node.
     * @param parent
     * @param child
     * @return
     */
    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Optional<Node<E>> parentResult = findBy(parent);
        Optional<Node<E>> childResult = findBy(child);
        if (parentResult.isPresent() && !childResult.isPresent()) {
            Node<E> parentNode = parentResult.get();
            Node<E> childNode = new Node<>(child);
            parentNode.add(childNode);
            result = true;
            this.modCount++;
            this.size++;
        }
        return result;
    }

    /**
     * find node by value using queue features.
     * @param value
     * @return
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> result = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> element = data.poll();
            if (element.eqValue(value)) {
                result = Optional.of(element);
                break;
            }
            for (Node<E> child : element.leaves()) {
                data.offer(child);
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new TreeIterator<>();
    }

    @Override
    public boolean isBinary() {
        boolean result = true;
        Queue<Node<E>> nodes = new LinkedList<>();
        nodes.offer(this.root);
        while (!nodes.isEmpty()) {
            Node<E> node = nodes.poll();
            if (node.leaves().size() > 2) {
                result = false;
                break;
            }
            for (Node<E> child : node.leaves()) {
                nodes.offer(child);
            }
        }
        return result;
    }

    final class TreeIterator<E extends Comparable<E>> implements Iterator<E> {
        boolean isRoot = false;
        Queue<Node<E>> data = new LinkedList<>();

        @Override
        public boolean hasNext() {
            return !data.isEmpty() || !isRoot;
        }

        @Override
        public E next() {
            Node<E> result;
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            if(!isRoot) {
                result = (Node<E>) root;
                isRoot = true;
            }else {
                result = data.poll();
            }
            for (Node<E> child : result.leaves()) {
                data.offer(child);
            }
            return result.getValue();
        }
    }
}