package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ArrayHomeTaskTest {
    @Test
    public void getUnitedArray() throws Exception {
        ArrayHomeTask arrayHomeTask = new ArrayHomeTask();
        int[] array1 = new int[]{1, 2, 2, 0, 4, 4, 12, 12, 10, 17, 0};
        int[] array2 = new int[]{133, 0, 133, 12, 12, 10, 17, 18, 17, 10};
        int[] input = arrayHomeTask.getUnitedArray(array1, array2);
        int[] expect = new int[]{1, 2, 2, 0, 4, 4, 12, 12, 10, 17, 0, 133, 0, 133, 12, 12, 10, 17, 18, 17, 10};
        assertThat(input, is(expect));
    }
}