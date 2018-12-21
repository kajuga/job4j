package ru.job4j.producerconsumer;

public class Consumer extends Thread {
    private final SimpleBlockingQueue<Integer> queue;

    public Consumer(SimpleBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int counter = 0;
        while (counter < 15) {
            counter++;
            try {
                System.out.println("Размер queue: " + (this.queue.sizeInformer() - 1) + ", вытащено число: " + this.queue.poll());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}