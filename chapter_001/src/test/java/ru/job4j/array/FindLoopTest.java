package ru.job4j.array;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {

    @Test
    public void whenArrayHasLengh5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHasLengh0Then666() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{15, 110, 23};
        int value = 0;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHasLengh0Then() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{125, 1210, 223};
        int value = 1210;
        int result = Arrays.binarySearch(input, value);
        int expect = 1;
        assertThat(result, is(expect));
    }
}