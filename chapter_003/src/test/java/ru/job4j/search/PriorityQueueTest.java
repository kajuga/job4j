package ru.job4j.search;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task result1 = queue.take();
        Task result2 = queue.take();
        Task result3 = queue.take();
        boolean condition = result1.getDesc().equals("urgent") && result2.getDesc().equals("middle") && result3.getDesc().equals("low") && queue.size() == 0;
        Assert.assertTrue(condition);
    }




}