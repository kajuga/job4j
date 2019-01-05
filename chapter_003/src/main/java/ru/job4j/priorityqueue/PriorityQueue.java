package ru.job4j.priorityqueue;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        //TODO добавить вставку в связанный список.
        this.tasks.add(task);

    }

    public Task take() {
        return this.tasks.poll();
    }
}

/*
public List<Person> find(String key) {
        return this.persons.stream()
                .filter(p -> p.getName().contains(key) || p.getAddress().contains(key) || p.getPhone().contains(key) || p.getSurname().contains(key))
                .collect(Collectors.toList());
    }
 */