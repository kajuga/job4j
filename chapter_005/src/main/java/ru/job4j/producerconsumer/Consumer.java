package ru.job4j.producerconsumer;

public class Consumer extends Thread {
    private SimpleBlockingQueue<Integer> queue;

    public Consumer(SimpleBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int counter = 0;
        while (counter < 10) {
            counter++;
            try {
//                queue.poll();
                System.out.println("Размер queue: " + (queue.sizeInformer() - 1) + ", вытащено число: " + queue.poll());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}