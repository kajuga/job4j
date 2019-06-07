package ru.job4j.trackersql;

import org.hamcrest.core.Is;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Mikhail Rozdin
 * @version $Id$
 * @since 0.1
 */

public class TrackersqlTest {
    private static Connection connection;


    @BeforeClass
    public static void init() {
        try (InputStream in = TrackersqlTest.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection =  DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            setTableItems();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static void setTableItems() {
        try (PreparedStatement ps =
                     connection.prepareStatement(
                             "    CREATE TABLE IF NOT EXISTS item (id SERIAL PRIMARY KEY NOT NULL, name VARCHAR(100), description VARCHAR(150), creation_date DATE NOT NULL);"
                                     +
                                     "    INSERT INTO tracker.item (name, description, creation_date) VALUES ('Incoming mail', 'description_text_fifth', 'Wed 17 Dec 03:27:13 2018 PST');\n" +
                                     "    INSERT INTO tracker.item (name, description, creation_date) VALUES ('Outcoming mail', 'description_text_fourth', NOW());\n" +
                                     "    INSERT INTO tracker.item (name, description, creation_date) VALUES ('Inner mail', 'description_text_second', 'Wed 12 Dec 07:37:14 1990 PST');\n" +
                                     "    INSERT INTO tracker.item (name, description, creation_date) VALUES ('Incoming mail', 'description_text_third', NOW());\n" +
                                     "    INSERT INTO tracker.item (name, description, creation_date) VALUES ('Unsorted mail', 'description_text_first', 'Wed 11 Jan 11:32:17 1991 PST');\n" +
                                     "    INSERT INTO tracker.item (name, description, creation_date) VALUES ('Inner mail', 'description_text_fourth', NOW());\n" +
                                     "    CREATE TABLE tracker.comment (id SERIAL PRIMARY KEY NOT NULL, comment VARCHAR(250), item_id INTEGER REFERENCES tracker.item(id));\n" +
                                     "    INSERT INTO tracker.comment (comment, item_id) VALUES ('commit_text_first', 3);\n" +
                                     "    INSERT INTO tracker.comment (comment, item_id) VALUES ('commit_text_second', 2);\n" +
                                     "    INSERT INTO tracker.comment (comment, item_id) VALUES ('commit_text_third', 4);\n" +
                                     "    INSERT INTO tracker.comment (comment, item_id) VALUES ('commit_text_fourth', 1);\n" +
                                     "    INSERT INTO tracker.comment (comment, item_id) VALUES ('commit_text_five', 1);\n" +
                                     "    INSERT INTO tracker.comment (comment, item_id) VALUES ('commit_text_six', 1);\n" +
                                     "    INSERT INTO tracker.comment (comment, item_id) VALUES ('commit_text_seven', 3);\n" +
                                     "    INSERT INTO tracker.comment (comment, item_id) VALUES ('commit_text_eight', 3);\n" +
                                     "    INSERT INTO tracker.comment (comment, item_id) VALUES ('commit_text_9', 3);\n" +
                                     "    INSERT INTO tracker.comment (comment, item_id) VALUES ('commit_text_10', 2);\n" +
                                     "    INSERT INTO tracker.comment (comment, item_id) VALUES ('commit_text_11', 2);\n" +
                                     "    INSERT INTO tracker.comment (comment, item_id) VALUES ('commit_text_12', 4);\n" +
                                     "    INSERT INTO tracker.comment (comment, item_id) VALUES ('commit_text_13', 4);\n" +
                                     "    INSERT INTO tracker.comment (comment, item_id) VALUES ('commit_text_14', 5);\n" +
                                     "    INSERT INTO tracker.comment (comment, item_id) VALUES ('commit_text_15', 5);\n" +
                                     "    INSERT INTO tracker.comment (comment, item_id) VALUES ('commit_text_16', 6);\n" +
                                     "    INSERT INTO tracker.comment (comment, item_id) VALUES ('commit_text_17', 6);\n" +
                                     "    INSERT INTO tracker.comment (comment, item_id) VALUES ('commit_text_18', 6);\n" +
                                     "    INSERT INTO tracker.comment (comment, item_id) VALUES ('commit_text_19', 6);"
                     )
        ) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }






    @Test
    public void whenAddFiveElementsDeleteOneThenFourElements() throws SQLException {
        try (Trackersql tracker = new Trackersql(connection)) {
//             connection.prepareStatement("INSERT INTO tracker.item (name, description, creation_date) VALUES ('Incoming mail', 'description_text_fifth', 'Wed 17 Dec 03:27:13 2018 PST');\n" +
//            "INSERT INTO tracker.item (name, description, creation_date) VALUES ('Outcoming mail', 'description_text_fourth', NOW());");

//            Item first = new Item("Incoming mail", "description_text_fifth");
//            Item second = new Item("secondTestItem", "secondTestDescription");
//            tracker.add(first);
//            tracker.add(second);
//            setTableItems();
            int expect = 6;
            int result = tracker.findAll().length;
            for (int i = 0; i < tracker.findAll().length; i++) {
                System.out.println(new Item[i]);
            }

            assertEquals(expect, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
////
//    @Test
//    public void whenAddFiveElementsThreeSameNameThenFoundsThreeElements() throws SQLException {
//        try (Trackersql tracker = new Trackersql(ConnectionRollback.create(this.init()))) {
//
//            Item first = new Item("test", "firstDescription");
//            Item second = new Item("second", "secondDescription");
//            Item third = new Item("test", "thirdDescription");
//            Item fours = new Item("fours", "foursDescription");
//            Item fives = new Item("test", "fivesDescription");
//            tracker.add(first);
//            tracker.add(second);
//            tracker.add(third);
//            tracker.add(fours);
//            tracker.add(fives);
//            LinkedList<Item> res = (LinkedList<Item>) tracker.findByName("test");
//
//            assertEquals(res.get(0), first);
//            assertEquals(res.get(1), third);
//            assertEquals(res.get(2), fives);
//        }
//    }
//
//
//    @Test
//    public void whenAddNewItemThenTrackerHasSameItem() throws SQLException {
//        try (Trackersql tracker = new Trackersql(ConnectionRollback.create(this.init()))) {
//
//            Item item = new Item("test1", "testDescription", 123L);
//            tracker.add(item);
//            assertEquals(tracker.findAll().get(0), item);
//
//        }
//    }
//
//
//    @Test
//    public void whenAddItemThenSameItemReturn() throws SQLException {
//        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
//            Item item = new Item("test1", "testDescription", 123L);
//            Item result = tracker.add(item);
//            assertThat(result, Is.is(item));
//
//        }
//    }
//
//    @Test
//    public void whenReplaceNameThenReturnNewName() throws SQLException {
//        try (Trackersql tracker = new Trackersql(ConnectionRollback.create(this.init()))) {
//
//            Item previous = new Item("test1", "testDescription");
//            tracker.add(previous);
//            Item next = new Item("test2", "testDescription2");
//            next.setId(previous.getId());
//            tracker.replace(previous.getId(), next);
//            assertThat(tracker.findById(previous.getId()).getName(), Is.is("test2"));
//
//        }
//    }
}
