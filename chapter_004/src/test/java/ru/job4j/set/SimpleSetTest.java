package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleSetTest {
    private SimpleSet<Integer> set;

    @Before
    public void beforeTest() {
        set = new SimpleSet<>();
    }

    /**
     * Проверка недопустимости добавления в сет двух одинаковых элементов.
     */
    @Test
    public void whenAddedTwoSameElementInSet() {
        assertThat(set.add(3), is(true));
        assertThat(set.add(555), is(true));
        assertThat(set.add(555), is(false));
        assertThat(set.add(3), is(false));
        assertThat(set.add(222), is(true));
    }
}