package ru.job4j.priorityqueue;

import java.util.Comparator;
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
        return this.tasks.stream()
//                .sorted((x, y) -> x.getPriority()-y.getPriority()).findFirst().get();
                .sorted(Comparator.comparingInt(Task::getPriority)).findFirst().get();
    }
}