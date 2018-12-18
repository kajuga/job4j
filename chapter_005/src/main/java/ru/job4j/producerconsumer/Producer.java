package ru.job4j.producerconsumer;

/**
 * Class produser - add 10 any random values in my queue.
 */
public class Producer extends Thread {
    private SimpleBlockingQueue <Integer> queue;

    public Producer(SimpleBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int counter = 0;
        int product = 0;
        while (counter < 10) {
            counter++;
            try {
                System.out.println("Размер queue: " + ((queue.sizeInformer() + 1) + ", засунуто число: " + ++product));
                queue.offer(product);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}