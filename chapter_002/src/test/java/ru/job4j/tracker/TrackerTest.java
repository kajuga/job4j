package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.*;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteInMiddle() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 123L);
        Item item2 = new Item("test2", "testDescription2", 123L);
        Item item3 = new Item("test3", "testDescription3", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.delete(item2.getId());
        Item[] expected = new Item[]{item1, item3};
        assertArrayEquals(expected, tracker.findAll());
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item one = new Item("a");
        Item two = new Item("b");
        Item three = new Item("a");
        Item four = new Item("c");
        tracker.add(one);
        tracker.add(two);
        tracker.add(three);
        tracker.add(four);
        Item[] actual = tracker.findByName("a");
        Item[] expected = new Item[]{one, three};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();
        Item item = new Item("a");
        Item item2 = new Item("b");
        tracker.add(item);
        tracker.add(item2);
        Item[] actual = tracker.findAll();
        Item[] expected = new Item[]{item, item2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item one = new Item("a");
        tracker.add(one);
        String[] actual = new String[]{one.getId()};
        String[] expected = new String[]{one.getId()};
        assertArrayEquals(expected, actual);
    }
}








