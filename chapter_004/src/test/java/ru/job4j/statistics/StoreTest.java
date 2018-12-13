package ru.job4j.statistics;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Store Test
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StoreTest {
    private List<User> previous = new ArrayList<>();
    private List<User> current = new ArrayList<>();

    @Before
    public void beforeTest() {
        previous.add(new User(221, "Vrumm"));
        previous.add(new User(543, "Bituun"));
        previous.add(new User(567, "Zollo"));
        previous.add(new User(235, "Alfonso"));
        previous.add(new User(565, "Sol"));
        previous.add(new User(111, "Rambo"));
        current.addAll(previous);
        current.set(0, new User(221, "MoDo"));
        current.set(1, new User(543, "Ivan"));
        current.remove(4);
        current.remove(4);
        current.remove(3);
        current.add(new User(777, "Adolf"));
        current.add(new User(888, "Burito"));
        current.add(new User(998, "Iggy Pop"));
        current.add(new User(444, "Snap"));
    }

    /**
     * Test diff
     * Сделал Store статиком, чтоб напрямую обращаться, не знаюнасколько это правильно  в тестах.
     */
    @Test
    public void whenCallDiffMethodThenReturnStatistics() {
        Info info = Store.differences(previous, current);
        assertThat(info.getAddCounter(), is(4));
        assertThat(info.getChangeCounter(), is(2));
        assertThat(info.getDelCounter(), is(3));
    }
}