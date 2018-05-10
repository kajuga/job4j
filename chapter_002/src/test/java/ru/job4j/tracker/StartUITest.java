package ru.job4j.tracker;

import org.junit.Test;
import java.io.IOException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() throws IOException {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() throws IOException {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        Input input = new StubInput(new String[]{"2", item.getId(), "test name", "desc", "87565654", "comment", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    @Test
    public void whenUserAddTwoItemThenTrackerMustShowTwoSameItems() throws IOException {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name1", "desc1", "0", "test name2", "desc2", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name1"));
        assertThat(tracker.findAll()[0].getDesc(), is("desc1"));
        assertThat(tracker.findAll()[1].getName(), is("test name2"));
        assertThat(tracker.findAll()[1].getDesc(), is("desc2"));
    }

    @Test
    public void whenUserAddThreeItemThenDeleteOneOfThemTrackerMustHaveTwoItems() throws IOException {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        Input input = new StubInput(new String[]{"0", "test name1", "desc1", "0", "test name2", "desc2", "3", tracker.findAll()[0].getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name1"));
        assertThat(tracker.findAll()[0].getDesc(), is("desc1"));
        assertThat(tracker.findAll()[1].getName(), is("test name2"));
        assertThat(tracker.findAll()[1].getDesc(), is("desc2"));
    }

    @Test
    public void whenUserAddItemThenFindItById() throws IOException {
        Tracker tracker = new Tracker();
        Item item = new Item("абырвалг", "главрыба");
        tracker.add(item);
        Input input = new StubInput(new String[]{"0", "test name1", "desc1", "4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("абырвалг"));
        assertThat(tracker.findAll()[0].getDesc(), is("главрыба"));
        assertThat(tracker.findAll()[0].getId(), is(item.getId()));

    }

    @Test
    public void whenUserAddItemThenFindItByName() throws IOException {
        Tracker tracker = new Tracker();
        Item item = new Item("first", "firstDesc");
        tracker.add(item);
        Input input = new StubInput(new String[]{"0", "test name1", "desc1", "5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(item.getName(), is("first"));
    }
}