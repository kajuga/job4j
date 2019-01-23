package ru.job4j.producerconsumer;

/**
 * Class produser - add 15 any values in my queue.
 */
public class Producer extends Thread {
    private final SimpleBlockingQueue<Integer> queue;
    boolean alldone = false;


    public Producer(SimpleBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int counter = 0;
        int product = 0;
        while (counter < 15) {
            counter++;
            try {
                System.out.println("Размер queue: " + ((queue.sizeInformer() + 1) + ", засунуто число: " + ++product));
                queue.offer(product);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.alldone = true;
        }
    }
}