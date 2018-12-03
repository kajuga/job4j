package ru.job4j.list;

import org.junit.Before;

import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ThreadSafeDynamicArrayTest {
    private DynamicArray<Integer> dynamicArray = new DynamicArray<>();
    private ThreadSafeDynamicArray<Integer> threadSafeDynamicArrayFirst = new ThreadSafeDynamicArray<>(dynamicArray);
    private ThreadSafeDynamicArray<Integer> threadSafeDynamicArraySecond = new ThreadSafeDynamicArray<>(dynamicArray);
    private ThreadSafeDynamicArray<Integer> threadSafeDynamicArrayThird = new ThreadSafeDynamicArray<>(dynamicArray);

    @Before
    public void beforeTest() {
        dynamicArray.add(11);
        dynamicArray.add(22);
        dynamicArray.add(33);
        dynamicArray.add(44);
        dynamicArray.add(55);
        dynamicArray.add(66);
        dynamicArray.add(77);
        dynamicArray.add(88);
    }
//todo
//something


}