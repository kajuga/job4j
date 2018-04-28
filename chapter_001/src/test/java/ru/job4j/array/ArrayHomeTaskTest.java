package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ArrayHomeTaskTest {
    @Test
    public void getSortedArrayWithoutDubles() throws Exception {
        ArrayHomeTask arrayHomeTask = new ArrayHomeTask();
        int[] array1 = new int[]{1, 2, 2, 0, 4, 4, 12, 12, 10, 17, 0};
        int[] array2 = new int[]{133, 0, 133, 12, 12, 10, 17, 18, 17, 10};
        int[] input = arrayHomeTask.getSortedArrayWithoutDubles(array1, array2);
        int[] expect = new int[]{0, 1, 2, 4, 10, 12, 17, 18, 133};
        assertThat(input, is(expect));
    }

    @Test
    public void noDuplicate() throws Exception {
        ArrayHomeTask arrayHomeTask = new ArrayHomeTask();
        int[] input = new int[]{1, 2, 10, 0, 4, 4, 12, 12, 10, 17, 0, 133, 0, 133, 12, 12, 10, 17, 18, 17, 2};
        int[] result = arrayHomeTask.noDuplicate(input);
        int[] expect = new int[]{1, 2, 10, 0, 4, 12, 133, 18, 17};
        assertThat(result, is(expect));

    }

    @Test
    public void bubbleSort() throws Exception {
        ArrayHomeTask arrayHomeTask = new ArrayHomeTask();
        int[] input = new int[]{1, 2, 10, 0, 4, 12, 133, 18, 17};
        int[] result = arrayHomeTask.bubbleSort(input);
        int[] expect = new int[]{0, 1, 2, 4, 10, 12, 17, 18, 133};
        assertThat(result, is(expect));
    }
}