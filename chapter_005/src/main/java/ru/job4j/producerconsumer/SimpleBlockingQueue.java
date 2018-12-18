package ru.job4j.producerconsumer;

import net.jcip.annotations.ThreadSafe;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 * synchronized multithreadung strucure - queue as LinkedList realisation.
 * @param <E>
 */

@ThreadSafe
public class SimpleBlockingQueue<E> {
    private volatile Queue<E> queue;

    /**
     * Constructor.
     */
    public SimpleBlockingQueue() {
        this.queue = new LinkedList<>();
    }

    /**
     * fill queue with checker.
     * @param e - putted element.
     * @throws InterruptedException
     */
    public synchronized void offer(E e) throws InterruptedException {
        int limitCheck = 10;
        while (this.queue.size() == limitCheck) {
            wait();
        }
        if(this.queue.size() < limitCheck) {
            notify();
        }
        this.queue.add(e);
    }

    /**
     * Getting element from queue.
     * @return element.
     * @throws InterruptedException
     */
    public synchronized E poll() throws InterruptedException {
        while (this.queue.isEmpty()) {
            wait();
        }
        if (queue.size() > 0) {
            notify();
        }
        return this.queue.remove();
    }

    public int sizeInformer(){
        return this.queue.size();
    }

    //isEmpty checker
    public synchronized boolean isEmpty() {
        return this.queue.isEmpty();
    }
}