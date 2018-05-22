package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StartUITest {
    private final String menu = new StringBuilder()
            .append("0. Add new Item" + System.lineSeparator())
            .append("1. Show all Items" + System.lineSeparator())
            .append("2. Edit Item." + System.lineSeparator())
            .append("3. Delete Item." + System.lineSeparator())
            .append("4. Find Item by Id." + System.lineSeparator())
            .append("5. Find Item by name." + System.lineSeparator())
            .toString();

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenUserChooseShowItemsInMenu() throws IOException {
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item item = new Item("111", "111");
        tracker.add(item);
        Input input = new StubInput(new String[]{"4", item.getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder(this.menu
                        )
                                .append("------------ Поиск заявки по id --------------" + System.lineSeparator())
                                .append("------------ Вывод на экран содержимого заявки: " + System.lineSeparator())
                                .append("name: 111" + System.lineSeparator())
                                .append("desc: 111" + System.lineSeparator())
                                .append("created: 0" + System.lineSeparator())
                                .append("comments: null" + System.lineSeparator())
                                .toString()
                )
        );
        System.setOut(stdout);
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() throws IOException {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test", "desc", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() throws IOException {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        Input input = new StubInput(new String[]{"2", item.getId(), "test name", "desc", "87565654", "comment", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    /**
     * N - использую в качестве самодельного символа-разделителя между выборором действий, ввиду конструктивной особенности вывода в консоль меню.
     *
     * @throws IOException
     */
    @Test
    public void whenUserAddTwoItemThenTrackerMustShowTwoSameItems() throws IOException {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name1", "desc1", "N", "0", "test name2", "desc2", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name1"));
        assertThat(tracker.findAll()[0].getDesc(), is("desc1"));
        assertThat(tracker.findAll()[1].getName(), is("test name2"));
        assertThat(tracker.findAll()[1].getDesc(), is("desc2"));
    }

    @Test
    public void whenUserAddThreeItemThenDeleteOneOfThemTrackerMustHaveTwoItems() throws IOException {
        Tracker tracker = new Tracker();
        tracker.add(new Item("first", "firstDesc"));
        Input input = new StubInput(new String[]{"0", "test name1", "desc1", "N", "0", "test name2", "desc2", "N", "3", tracker.findAll()[0].getId(), "y"});
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
        Input input = new StubInput(new String[]{"0", "test name1", "desc1", "N", "4", item.getId(), "y"});
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
        Input input = new StubInput(new String[]{"0", "test name1", "desc1", "N", "5", item.getName(), "y"});
        new StartUI(input, tracker).init();
        assertThat(item.getName(), is("first"));
    }
}