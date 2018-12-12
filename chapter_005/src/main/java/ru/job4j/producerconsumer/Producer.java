package ru.job4j.producerconsumer;

public class Producer extends Thread {
    private volatile SimpleBlockingQueue<Integer> queue;

    public Producer(SimpleBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int product = 0;
        int counter = 0;
        while (counter < 10) {
            counter++;
            try {
                queue.offer(++product);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}