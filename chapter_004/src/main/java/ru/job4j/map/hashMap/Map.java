package ru.job4j.map.hashMap;

/**
 * Интерфейс для hashMap
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 * @param <K> key.
 * @param <V> value.
 */

public interface Map<K, V> extends Iterable {
    boolean insert (K key, V value);
    boolean delete (K key);
    V get (K key);
}