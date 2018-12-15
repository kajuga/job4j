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
    private volatile Queue<E> queue;

    private SimpleBlockingQueue() {
        this.queue = new LinkedList<>();
    }

    public synchronized void offer(E e) throws InterruptedException {
        int limitCheck = 3;
        while (this.queue.size() == limitCheck) {
            wait();
        }
        if(this.queue.size() < limitCheck) {
            notify();
        }
        this.queue.add(e);
    }


    public synchronized E poll() throws InterruptedException {
        while (this.queue.isEmpty()) {
            wait();
        }
        if (queue.size() > 0) {
            notify();
        }
        return this.queue.remove();
    }



}