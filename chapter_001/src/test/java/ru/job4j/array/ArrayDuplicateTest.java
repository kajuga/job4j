package ru.job4j.array;

import org.junit.Test;

import java.lang.reflect.Array;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate array = new ArrayDuplicate();
        String[] input = new String[]{"alpha", "beta", "alpha", "gamma", "beta", "alpha", "beta"};
        String[] result = array.remove(input);
        String[] expect = new String[]{"alpha", "beta", "gamma"};
        assertThat(result, is(expect));
    }
}