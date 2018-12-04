package ru.job4j.producerconsumer;

public class Consumer extends Thread {
    private SimpleBlockingQueue queue;

    public Consumer(SimpleBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int counter = 0;
        while (counter < 10) {
            counter++;
            try {
                queue.poll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}