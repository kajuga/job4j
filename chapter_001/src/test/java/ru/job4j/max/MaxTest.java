package ru.job4j.max;

import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MaxTest {
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenSecondLessFirst() {
        Max maxim = new Max();
        int result = maxim.max(2, 1);
        assertThat(result, is(2));
    }

    @Test
    public void whenFirstEqualsSecond() {
        Max equal = new Max();
        int result = equal.max(2, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenFirstLessSecondButBiggerThird() {
        Max maxim = new Max();
        int result = maxim.max(4, 5, 2);
        assertThat(result, is(5));
    }

    @Test
    public void whenSecondBiggerFirstButLessThird() {
        Max maxim = new Max();
        int result = maxim.max(1, 2, 3);
        assertThat(result, is(3));
    }

}

