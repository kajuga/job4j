package ru.job4j.producerconsumer;

import net.jcip.annotations.ThreadSafe;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 * synchronized multithreadung strure - queue.
 * @param <E>
 */

@ThreadSafe
public class SimpleBlockingQueue<E> {
    private Queue<E> queue;

    public SimpleBlockingQueue() {
        this.queue = new LinkedList <>();
    }

    //produser
    public synchronized void offer(E e) throws InterruptedException {
        int limitChecker = 3;
        while (this.queue.size() == limitChecker) {
            wait();
        } if (this.queue.size() < limitChecker) {
            notify();
        }
        this.queue.add(e);
    }

    //customer
    public synchronized E poll() throws InterruptedException {
        while (isEmpty()) {
            wait();
        }
        if (queue.size() > 0) {
            notify();
        }
        return this.queue.remove();
    }

    //isEmpty checker
    public synchronized boolean isEmpty() {
        return this.queue.isEmpty();
    }
}