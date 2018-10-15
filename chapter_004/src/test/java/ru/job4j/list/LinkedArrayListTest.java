package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LinkedArrayListTest {
private LinkedArrayList<Integer> list;

    @Before
        public void beforeTest() {
        list = new LinkedArrayList<>();
        list.add(11);
        list.add(77);
        list.add(55);
        list.add(22);
    }


    @Test
        public void whenAddedThreeSizeIsThree() {
        assertThat(list.getSize(), is(4));
    }

    @Test
        public void whenAddedThreeThenGetFirstInRowElement() {
        assertThat(list.get(0), is(11));
    }
    @Test
        public void whenAddedThreeThenGetThirdInRowElement() {
        assertThat(list.get(2), is(55));
    }

    @Test(expected = ConcurrentModificationException.class)
        public void concurrentModificationExceptionTest() {
            Iterator<Integer> it = list.iterator();
            it.next();
            it.next();
            list.add(2);
            it.next();
        }

    @Test
    public void whenAddFourElementsThenDeleteFirstAndLast() {
        assertThat(list.dropLast(), is(22));
        assertThat(list.dropFirst(), is(11));
        assertThat(list.get(0), is(77));
    }
}