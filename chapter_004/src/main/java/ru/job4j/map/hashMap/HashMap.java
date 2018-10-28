package ru.job4j.map.hashMap;

import ru.job4j.list.SimpleArrayList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * HashMap realisaion.
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 */

public class HashMap<K, V> implements Map <K, V> {

    private Node<K, V>[] hashTable;
    private int size;
    private float threshold;



    public HashMap() {
        this.hashTable = new Node[16];
        threshold = (float) (hashTable.length * 0.75);
    }

    @Override
    public boolean insert(K key, V value) {
        //расширение массива
        if(size + 1 >= threshold) {
            threshold *= 2;
            arrayDoubling();
        }

        Node<K, V> newNode = new Node <>(key, value);
        int index = newNode.hash;
        if(hashTable[index] == null) {
            return simpleAdd(index, newNode);
        }

        List<Node<K, V>> nodeList = hashTable[index].getNodes();
        for(Node<K, V> node : nodeList) {
            if (keyExistButValueNew(node, newNode, value) || collisionProcessing(node, newNode, nodeList)) {
                return true;
            }
        }
        return false;
    }

    private boolean simpleAdd(int index, Node<K, V> newNode) {
        hashTable[index] = new Node<>(null, null);
        hashTable[index].getNodes().add(newNode);
        size++;
        return true;
    }

    private boolean keyExistButValueNew(Node<K, V> nodeFromList, Node<K, V> newNode, V value) {

        if(newNode.getKey().equals(nodeFromList.getKey()) && !newNode.getValue().equals(nodeFromList.getValue())) {
            nodeFromList.setValue(value);
            return true;
        }
        return false;

    }

    /**
     * Добавление/недобавление нового узла в список нодов.
     * @param nodeFromList
     * @param newNode
     * @param nodes
     * @return
     */
    private boolean collisionProcessing(Node<K, V> nodeFromList, Node<K, V> newNode, List<Node<K, V>> nodes) {
        if(newNode.hashCode() == nodeFromList.hashCode() && !Objects.equals(newNode.key, nodeFromList.key) && !Objects.equals(newNode.value, nodeFromList.value)) {
            nodes.add(newNode);
            size++;
            return true;
        }
        return false;
    }

    private void arrayDoubling(){
        Node<K, V>[] oldHashTable = hashTable;
        hashTable = new Node[oldHashTable.length * 2];
        size = 0;
        for (Node<K, V> node : oldHashTable) {
            if (node != null) {
                for (Node<K, V> n : node.getNodes()) {
                    insert(n.key, n.value);
                }
            }
        }
    }




    private class Node<K, V> {
        private List<Node<K, V>> nodes;
        private int hash;
        private K key;
        private V value;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
            nodes = new LinkedList <Node<K, V>>();
        }

        private List <Node <K, V>> getNodes() {
            return nodes;
        }

        private int hash() {
            return hashCode() % hashTable.length;
        }

        private K getKey() {
            return key;
        }

        private V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//
//            Node <?, ?> node = (Node <?, ?>) o;
//
//            return key.equals(node.key);
//        }

        @Override
        public int hashCode() {
            hash = 31;
            hash = hash * 17 + key.hashCode();
            return hash;
        }
    }
















    @Override
    public boolean delete(Object key) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
