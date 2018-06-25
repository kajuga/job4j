package ru.job4j.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {
    @Test
    public void when8ElementsThen2() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8),
                2
        );
        int[][] expect = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when7ElementsThen3() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0},
        };
        assertThat(result, is(expect));
    }


    @Test
    public void when7ElementsThen4() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                4
        );
        int[][] expect = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 0},
        };
        assertThat(result, is(expect));
    }


    @Test
    public void when3ArrayThenOne(){
        ConvertList2Array list = new ConvertList2Array();
        List integers = new ArrayList();
        integers.add(new int[]{1, 2});
        integers.add(new int[]{3, 4, 5});
        integers.add(new int[]{6, 7, 8, 9});
        List result = list.convert(integers);
        List expect = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Assert.assertEquals(result, expect);







    }



}




