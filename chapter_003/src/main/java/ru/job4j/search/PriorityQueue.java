package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    LinkedList<Task> tasks = new LinkedList<>();

    public static void main(String[] args) {
        PriorityQueue myQueue = new PriorityQueue();
        Task task1 = new Task("First", 1);
        Task task3 = new Task("Third", 5);
        Task task2 = new Task("Middle", 3);
        myQueue.put(task1);
        myQueue.put(task3);
        myQueue.put(task2);
        myQueue.print();
        System.out.println("Size of LinkedList: " + myQueue.size());
    }

    public void print() {
        for (Task tsk : tasks) {
            System.out.println(tsk.getDesc());
        }
    }

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        int size = this.tasks.size();
        boolean isPut = false;
        for (int i = 0; i < size; i++) {
            if (task.getPriority() <= tasks.get(i).getPriority()) {
                this.tasks.add(i, task);
                isPut = true;
                break;
            }
        }
        if (!isPut) {
            tasks.add(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }

    public int size() {
        return tasks.size();
    }
}