package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DynamicArrayTest {
    private DynamicArray<Integer> list;

    @Before
    public void beforeTest() {
        list = new DynamicArray<>();
        list.add(1);
        list.add(5);
        list.add(7);
    }

    @Test
    public void whenAddedThreeSizeIsThree() {
        assertThat(list.size(), is(3));
    }

    @Test
    public void whenAddedThreeThenGetThird() {
        assertThat(list.get(2), is(7));
    }

    @Test
    public void whenAddedThreeThenAddTenSizeIsThirteen() {
        list.add(12);
        list.add(12);
        list.add(12);
        list.add(12);
        list.add(12);
        list.add(12);
        list.add(12);
        list.add(12);
        list.add(12);
        list.add(12);
        assertThat(list.size(), is(13));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void concurrentModificationExceptionTest() {
        Iterator<Integer> it = list.iterator();
        it.next();
        it.next();
        list.add(2);
        it.next();
    }
}