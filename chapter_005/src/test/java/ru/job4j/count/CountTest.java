package ru.job4j.count;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CountTest {
    private class ThreadCount extends Thread {
        private final Count count;

        private ThreadCount(final Count count) {
            this.count = count;
        }

        @Override
        public void run() {
            this.count.increment();
        }
    }

    @Test
    public void whenExecute2ThreadThen2() throws InterruptedException {
        final Count count = new Count();
        Thread first = new ThreadCount(count);
        Thread second = new ThreadCount(count);
        Thread third = new ThreadCount(count);
        Thread fourth = new ThreadCount(count);
        first.start();
        second.start();
        fourth.start();
        third.start();
        third.join();
        fourth.join();
        first.join();
        second.join();
        assertThat(count.get(), is(4));
    }
}