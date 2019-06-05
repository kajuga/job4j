package ru.job4j.tracker;

public interface ITracker {
    Item add(Item item);
    void replace(String id, Item item);
    boolean delete(String id);
    Item[] findAll();
    Item[] findByName(String key);
    Item findById(String id);
}