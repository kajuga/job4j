package ru.job4j.producerconsumer;

/**
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 * Реализация последовательной работы связки "producer-consumer"
 */
public class ConsistentlyAndParallelExecution {
    public static void main(String[] args) throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();
        Thread producer = new Thread(new Producer(queue));
        Thread comsumer = new Thread(new Consumer(queue));
        //запуск поседовательно:
        producer.run();
        producer.join();
        Thread.sleep(1000);
        comsumer.run();
        comsumer.join();
        System.out.println("Size my queue is: " + queue.sizeInformer());
        System.out.println("Последовательный запуск завершен!");
        Thread.sleep(2000);
    }
}