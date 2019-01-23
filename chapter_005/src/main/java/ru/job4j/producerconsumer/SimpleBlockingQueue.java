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
    volatile boolean alldone = false;

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
    public void offer(E e) throws InterruptedException {
        synchronized (this) {
            while (alldone) {
                this.wait();
            }
            if (isEmpty()) {
                this.notify();
            }
            this.queue.add(e);
        }
    }

    /**
     * Getting element from queue.
     * @return element.
     * @throws InterruptedException
     */
    public  E poll() throws InterruptedException {
        synchronized (this) {
            while (isEmpty()) {
                this.wait();
            }
            if (!isEmpty()) {
                this.notify();
            }
            return this.queue.remove();
        }
    }

    public int sizeInformer() {
        return this.queue.size();
    }

    //isEmpty checker
    public synchronized boolean isEmpty() {
        return this.queue.isEmpty();
    }
}