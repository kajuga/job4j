package ru.job4j.map.hashMap;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * HashMap realisaion.
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 */
public class HashMap<K, V> implements Map<K, V> {
    public Node<K, V>[] hashTable;
    public int size = 0;
    private float threshold;

    /**
     * Конструктор.
      */
    public HashMap() {
        hashTable = new Node[16];
        threshold = hashTable.length * 0.75f;
    }

    /**
     * Вставка элемента.
     * Описаны два случая вставки: в прустую корзину  - simpleAdd(); занятую  - collisionProcessing().
     * @param key - ключ.
     * @param value - значение
     * @return result вставки.
     */
    @Override
    public boolean insert(final K key, final V value) {
        if(size + 1 >= threshold) {
            threshold *= 2;
            arrayDoubling();
        }

        Node<K, V> newNode = new Node<>(key, value);
        int index = hash(key);
        if (hashTable[index] == null) {
            return simpleAdd(index, newNode);
        }

        List<Node<K, V>> nodeList = hashTable[index].getNodes();
        for(Node<K, V> node : nodeList) {
            if (keyExistButValueNew(node, newNode, value) ||
                    collisionProcessing(node, newNode, nodeList)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Вставка ноды в пустую корзину hashTable.
     * @param index номер корзины
     * @param newNode новая нода.
     * @return
     */
    private boolean simpleAdd(int index, Node<K, V> newNode) {
        hashTable[index] = new Node<>(null, null);
        hashTable[index].getNodes().add(newNode);
        size++;
        return true;
    }

    /**
     * Перезапись value ноды в случае совпадения ключа.
     * @param nodeFromList  - нода со старым значением.
     * @param newNode - новая.
     * @param value - новое value.
     * @return
     */
    private boolean keyExistButValueNew(
            final Node<K, V> nodeFromList,
            final Node<K, V> newNode,
            final V value) {
        if(newNode.getKey().equals(nodeFromList.getKey()) &&
                !newNode.getValue().equals(nodeFromList.getValue())) {
            nodeFromList.setValue(value);
            return true;
        }
        return false;
    }

    /**
     * Обработка  коллизии.
     * Новая и уже лежашие в корзине ноды сравниваются по хэшкодам и value.
     * @param nodeFromList  -  "старая".
     * @param newNode - "новая"
     * @param nodes - список нод в листе.
     * @return
     */
    private boolean collisionProcessing(final Node<K, V> nodeFromList,
                                        final Node<K, V> newNode,
                                        final List<Node<K, V>> nodes) {
        if(newNode.hashCode() == nodeFromList.hashCode() &&
                !Objects.equals(newNode.key, nodeFromList.key) &&
                !Objects.equals(newNode.value, nodeFromList.value)) {
            nodes.add(newNode);
            size++;
            return true;
        }
        return false;
    }

    /**
     * Реализация увеличения размера массива х2.
     * Старая переписывается в х2 новую, size сбрасывается на 0;
     */
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

    /**
     * Delete по ключу.
     * @param key
     * @return
     */
    @Override
    public boolean delete(final K key) {
        int index = hash(key);
            if(hashTable[index] == null) {
                return false;
            }
            if (hashTable[index].getNodes().size() == 1) {
                hashTable[index] = null;
                return true;
        }
        List<Node<K, V>> nodeList = hashTable[index].getNodes();
            for (Node<K, V> node : nodeList) {
                if (key.equals(node.getKey())) {
                    nodeList.remove(node);
                    return true;
                }
            }
            return false;
    }

    /**
     * Get по ключу.
     * @param key
     * @return
     */
    @Override
    public V get(final K key) {
        int index = hash(key);
        if(index < hashTable.length &&
                hashTable[index] != null) {
            if (hashTable[index].getNodes().size() == 1) {
                return hashTable[index].getNodes().get(0).getValue();
            }
            List<Node<K, V>> list = hashTable[index].getNodes();
            for (Node<K, V> node : list) {
                if (key.equals(node.getKey())) {
                    return node.getValue();
                }
            }
        }
          return null;
    }

    public int size() {
        return size;
    }

    /**
     * Дополнительный метод - добавил для теста, иначе никак у мня не получается в тестах hashTable.length вытащить.
     * @return
     */
    public int hashTableLength() {
        return hashTable.length;
    }

    /**
     * Переопределил hash ключа для равномерного заполнения hashTable.
     * @param key
     * @return
     */
    private int hash(final K key) {
        int hash = 31;
        hash = hash * 17 + key.hashCode();
        return hash % hashTable.length;
    }

    /**
     * Итератор.
     * @return
     */
    @Override
    public Iterator<V> iterator() {
        return new Iterator <V>() {
            int counterArray = 0;
            int valuesCounter = 0;
            Iterator<Node<K, V>> subIterator = null;

            @Override
            public boolean hasNext() {
                if (valuesCounter == size) {
                    return false;
                }
                if (subIterator == null || !subIterator.hasNext()) {
                    if (moveToNextCell()) {
                        subIterator = hashTable[counterArray].getNodes().iterator();
                    } else {
                        return false;
                    }
                }
                return subIterator.hasNext();
            }
            private boolean moveToNextCell() {
                counterArray++;
                while (hashTable[counterArray] == null) {
                    counterArray++;
                }
                return hashTable[counterArray] != null;
            }

            @Override
            public V next() {
                valuesCounter++;
                return subIterator.next().getValue();
            }
        };
    }

    /**
     * Релизация нод в корзине таблицы. Каждая  - LinkedList.
     * @param <K> key.
     * @param <V> value.
     *  hash - определяет методом % в какую корзину будет записана нода.
     */
    private class Node<K, V> {
        private List<Node<K, V>> nodes;
        private int hash;
        private K key;
        private V value;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
            nodes = new LinkedList<Node<K, V>>();
        }

        /**
         * Возвращает из корзины список нод, в которой лежит нужная нода.
         * @return
         */
        private List <Node <K, V>> getNodes() {
            return nodes;
        }

//        private int hash() {
//            return hashCode() % hashTable.length;
//        }

        private K getKey() {
            return key;
        }

        private V getValue() {
            return value;
        }

        private void setValue(V value) {
            this.value = value;
        }

        /**
         * Переопределил hashCode для равномерного заполнения таблицы.
         * @return
         */
        @Override
        public int hashCode() {
            hash = 31;
            hash = hash * 17 + key.hashCode();
            return hash;
        }

        /**
         * и переопределил equals
         * @param obj
         * @return
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj instanceof Node) {
                Node<K, V> node = (Node) obj;
                return (Objects.equals(key, node.getKey()) &&
                        Objects.equals(value, node.getValue()) ||
                        Objects.equals(hash, node.hashCode()));
            }
            return false;
        }
    }
}

