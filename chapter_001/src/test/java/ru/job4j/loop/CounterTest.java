package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CounterTest {
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        Counter counter = new Counter();
        int result = counter.add(1, 10);
        int expected = 30;
        assertThat(result, is(expected));
    }

    @Test
    public void whenSumEvenNumbersFromMinusTenToFiveThenMinusTwentyFour() {
        Counter counter = new Counter();
        int result = counter.add(-10, 5);
        int expected = -24;
        assertThat(result, is(expected));
    }
}