package ru.job4j.list;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

public class SimpleStackTest {
    private SimpleStack<Integer> stack;

    @Before
    public void beforeTest() {
        stack = new SimpleStack<>();
        stack.push(3);
        stack.push(6);
        stack.push(12);
        stack.push(999);
    }

    @Test
    public void whenAddedElementsIsGetOut() {
        assertThat(stack.poll(), is(999));
        assertThat(stack.poll(), is(12));
        assertThat(stack.poll(), is(6));
        assertThat(stack.poll(), is(3));
    }
}