package ru.job4j.trackersql;

import org.hamcrest.core.Is;
import org.junit.Test;
import ru.job4j.tracker.Item;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackersqlTest {

    public Connection init() {
        try (InputStream in = TrackersqlTest.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() throws SQLException {
        try (Trackersql tracker = new Trackersql(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name", "desc"));
            assertThat(tracker.findByName("name").length, is(1));
        }
    }

    @Test
    public void whenAddFiveElementsDeleteOneThenFourElements() throws SQLException {
        try (Trackersql tracker = new Trackersql(ConnectionRollback.create(this.init()))) {
            Item first = new Item("first", "firstDescription");
            Item second = new Item("second", "secondDescription");
            tracker.add(first);
            tracker.add(second);
            List<Item> res = Arrays.asList(tracker.findAll());
            assertEquals(res.get(0), first);
            assertEquals(res.get(1), second);
        }
    }

    @Test
    public void whenAddFiveElementsThreeSameNameThenFoundsThreeElements() throws SQLException {
        try (Trackersql tracker = new Trackersql(ConnectionRollback.create(this.init()))) {
            Item first = new Item("test", "firstDescription");
            Item second = new Item("second", "secondDescription");
            Item third = new Item("test", "thirdDescription");
            Item fours = new Item("fours", "foursDescription");
            Item fives = new Item("test", "fivesDescription");
            tracker.add(first);
            tracker.add(second);
            tracker.add(third);
            tracker.add(fours);
            tracker.add(fives);
            List<Item> res = Arrays.asList(tracker.findByName("test"));
            assertEquals(res.get(0), first);
            assertEquals(res.get(1), third);
            assertEquals(res.get(2), fives);
        }
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws SQLException {
        try (Trackersql tracker = new Trackersql(ConnectionRollback.create(this.init()))) {
            Item item = new Item("test1", "testDescription", 123L);
            Item[] items = new Item[]{item};
            tracker.add(item);
            assertEquals(tracker.findAll().length, items.length);
            assertEquals(tracker.findAll()[0], item);
        }
    }

    @Test
    public void whenReplaceNameThenReturnNewName() throws SQLException {
        try (Trackersql tracker = new Trackersql(ConnectionRollback.create(this.init()))) {
            Item old = tracker.add(new Item("test1", "testDescription"));
            Item newItem = new Item("test2", "testDescription2", 123L);
            tracker.replace(old.getId(), newItem);
            assertThat(tracker.findById(old.getId()).getName(), Is.is("test2"));
        }
    }
}