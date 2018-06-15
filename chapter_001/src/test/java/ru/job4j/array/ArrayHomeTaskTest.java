package ru.job4j.array;

import org.hamcrest.core.Is;
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

    @Test
    public void getUniTedArrayNoBubble() throws Exception {
        ArrayHomeTask arrayHomeTask = new ArrayHomeTask();
        int[] one = {1, 2, 3, 5};
        int[] two = {1, 4, 5, 6};
        int[] result = arrayHomeTask.getUnitedArrayWithBubble(one, two);
        int[] expected = {1, 1, 2, 3, 4, 5, 5, 6};
        assertThat(result, Is.is(expected));
    }

    @Test
    public void getUnitedArrayWithBubble() throws Exception {
        ArrayHomeTask arrayHomeTask = new ArrayHomeTask();
        int[] one = {0, 2, 1, 3};
        int[] two = {1, 0, 3, 4, 0};
        int[] result = arrayHomeTask.getUnitedArrayWithBubble(one, two);
        int[] expected = {0, 0, 0, 1, 1, 2, 3, 3, 4};
        assertThat(result, Is.is(expected));
    }
}