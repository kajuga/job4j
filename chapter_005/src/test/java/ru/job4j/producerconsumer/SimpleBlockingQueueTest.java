package ru.job4j.producerconsumer;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleBlockingQueueTest {
    private SimpleBlockingQueue<Integer> queue;

    @Before
    public void beforeTest() {
        queue = new SimpleBlockingQueue<>();
    }

    /**
     * Test Producer and Consumer with some visualisation added.
     */
    @Test
    public void whenRunProducerAndConsumerAsThreadsThenAnyThreadBlockSharedQueue() {
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        producer.start();
        consumer.start();
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        assertThat(queue.isEmpty(), is(true));
    }
}