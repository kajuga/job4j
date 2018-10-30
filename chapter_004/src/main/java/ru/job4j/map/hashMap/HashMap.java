package ru.job4j.map.hashMap;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * HashMap realisaion.
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 * @param <K> key.
 * @param <V> value.
 * Node<K, V>[] hashTable - массив корзин для cписков нод <key, value>.
 * size - чеккер количества нодов списка в корзине.
 * threshold - параметр, контроллирующий заполненность таблицы-массива.
 */
public class HashMap<K, V> implements Map<K, V> {
    public static void main(String[] args) {
        HashMap<String, String> strings = new HashMap <>();
        strings.insert("a", "b");
        System.out.println(strings.get("a"));
    }


    private Node<K, V>[] hashTable;
    private int size = 0;
    private float threshold;

    /**
     * Constructor - инициализирую масив, параметр threshold выставляется как 0.75 от его длины.
     */
    public HashMap() {
        hashTable = new Node[16];
        threshold = (float) (hashTable.length * 0.75);
    }

    /**
     * Метод - вставка в мапу.
     * @param key - key.
     * @param value - value.
     * сверка size с threshold, при возрастании количества нодов в корзине до соотношения
     * ~0.75 к размеру хеш таблицы,  таблица увеличивается/перезаписывается в новый х2 массив методом arrayDoubling().
     * @return boolean result
     */
    @Override
    public boolean insert(K key, V value) {
        //расширение массива при заполненности -> 0.75
        if(size + 1 >= threshold) {
            threshold *= 2;
            arrayDoubling();
        }
        //создается нода, присваевается номер бакета (index), куда ее поместить; если не занято, то simpleAdd() реализует добавление
        Node<K, V> newNode = new Node<>(key, value);
        int index = hash(key);
        if(hashTable[index] == null) {
            return simpleAdd(index, newNode);
        }
        //вытаскиваеся список нод из бакета[index], пробегаемся по списку; перезаписываем в случае keyExistButValueNew() или дописываем следом, при коллизии
        //collisionProcessing()
        List<Node<K, V>> nodeList = hashTable[index].getNodes();
        for(Node<K, V> node : nodeList) {
            if (keyExistButValueNew(node, newNode, value) || collisionProcessing(node, newNode, nodeList)) {
                return true;
            }
        }
        return false;
    }

    /**
     * добавление ноды в незанятую корзину;
     * @param index
     * @param newNode
     * @return
     */
    private boolean simpleAdd(int index, Node<K, V> newNode) {
        hashTable[index] = new Node<>(null, null);
        hashTable[index].getNodes().add(newNode);
        size++;
        return true;
    }

    /**
     * Если корзина не пустая, проверяю список нод на равенство ключей: ключи равны, но value - нет - тогда "ок" на запись нового value поверх старого.
     * @param nodeFromList
     * @param newNode
     * @param value
     * @return
     */
    private boolean keyExistButValueNew(Node<K, V> nodeFromList, Node<K, V> newNode, V value) {
        if(newNode.getKey().equals(nodeFromList.getKey()) && !newNode.getValue().equals(nodeFromList.getValue())) {
            nodeFromList.setValue(value);
            return true;
        }
        return false;
    }

    /**
     * Проверка коллизии в списке из корзины.
     * берем лист: если хэши равны, то и попадают объекты в одну корзинку списком, при этом должны !equals сами объекты ()
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
    public boolean delete(K key) {
        int index = hash(key);
            if(hashTable[index] == null) {
                return false;
            }
            if (hashTable[index].getNodes().size() == 1) {
                hashTable[index].getNodes().remove(0);
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
    public V get(K key) {
        int index = hash(key);
        if(index < hashTable.length && hashTable[index] != null) {
            List<Node<K, V>> list = hashTable[index].getNodes();
            for (Node<K, V> node : list) {
                if (key.equals(node.getKey())) {
                    return node.getValue();
                }
            }
        }
        return null;
    }

    /**
     *
     * @return номер корзины внутреннего массива.
     */
    private int hash(K key) {
        return hashCode() % hashTable.length;
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
            nodes = new LinkedList <Node<K, V>>();
        }

        /**
         * Возвращает из корзины список нод, в которой лежит нужная нода.
         * @return
         */
        private List <Node <K, V>> getNodes() {
            return nodes;
        }



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
         * @param o
         * @return
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node <?, ?> node = (Node <?, ?>) o;
            return key.equals(node.key);
        }
    }

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
}

