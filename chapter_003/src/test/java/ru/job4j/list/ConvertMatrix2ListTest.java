package ru.job4j.list;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertMatrix2ListTest {
    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void when2on2ArrayThenList4ver2() {
        ConvertMatrix2List matrix = new ConvertMatrix2List();
        int[][] arr = {{1, 2, 3}, {4, 5, 6}};
        List<Integer> result = matrix.toList(arr);
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(expect, is(result));
    }

    @Test
    public void when2on2ArrayThenList4WithForEach() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4
        );
        List<Integer> result = list.toListWithForEach(input);
        assertThat(result, is(expect));
    }

    @Test
    public void when3on4ArrayThenList12() {
        ConvertMatrix2List convertMatrix2List = new ConvertMatrix2List();
        int[][] input = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 0, 0}
        };
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0);
        List<Integer> result = convertMatrix2List.toList(input);
        assertThat(result, is(expect));
    }
}
