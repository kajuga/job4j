package ru.job4j.list;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleStackTest {
    private SimpleStack<Integer> stack;

    @Before
    public void beforeTest() {
        stack = new SimpleStack <>();
        stack.push(3);
        stack.push(6);
        stack.push(12);
        stack.push(999);
    }

    @Test
    public void whenAddedFourSizeIsFour() {
        assertThat(stack.getSize(), is(4));
    }

    @Test
    public void whenAddedlastIsOutFirstAndSizeDecreased() {
        assertThat(stack.poll(), is(999));
        assertThat(stack.getSize(), is(3));
        assertThat(stack.poll(), is(12));
        assertThat(stack.getSize(), is(2));
    }



}