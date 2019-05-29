package ru.job4j.trackersql;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.Item;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Locale;
import java.util.Properties;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerSQLTest {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/job4j_database";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private Connection connection;

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Connection Test
    @Test
    public void checkConnection() {
        if (connection == null) {
            try {
                Locale.setDefault(Locale.ENGLISH);
                connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        /**
         * Select all testing
         */
//    @Test
//    public void whenFindAll() {
//        Trackersql trackersql = new Trackersql();
//        Item itemOne = new Item("ItemOne", "blablabla", LocalDate.of(2019, 5, 4).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
//        String[] itemOneComments = {"Первый коммент итема №1", "Второй коммент итема №1"};
//        itemOne.setComments(itemOneComments);
//        Item itemTwo = new Item("ItemTwo", "arrggh!", LocalDate.of(1945, 5, 9).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
//        String[] itemTwoComments = {"Первый коммент итема #2", "Второй коммент итема #2", "Третий коммент итема #2"};
//        itemTwo.setComments(itemTwoComments);
//
//        trackersql.add(itemOne);
//        trackersql.add(itemTwo);
//        Item[] actual = trackersql.findAll();
//        Item[] expected = new Item[]{itemOne, itemTwo};
//        assertArrayEquals(expected, actual);
//    }
//
//    /**
//     * Add testiong
//     */
//    @Test
//        public void testAdd () {

//        Item[] temp = trackersql.findAll();
//        for (Item i : temp) {
//            System.out.println(i);
//        }
//        Item itemNew = new Item("NewTestItem", "blablabla", LocalDate.of(2019, 5, 4).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
//        String[] tempComments = {"Первый коммент нового итема", "Второй коммент нового итема"};
//        itemNew.setComments(tempComments);
//        System.out.println("======");
//
//        //add test
//        trackersql.add(itemNew);
//        Item[] temp2 = trackersql.findAll();
//        for (Item i : temp2) {
//            System.out.println(i);
//        }
//    }
//
//
//    //replace testing
//    Item itemNew = new Item("NewTestItem", "blablabla", LocalDate.of(1945, 5, 9).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
//    String[] tempComments = {"Первый коммент нового-замененного итема", "Второй коммент нового-замененного итема"};
//        itemNew.setComments(tempComments);
//        System.out.println("======итем создан, ехаем дальше========");
//        System.out.println();
//        System.out.println("===замена пятого итема вот этим новым ========");
//        trackersql.replace(String.valueOf(5), itemNew);
//
//        System.out.println("==== findByName ====");
//
//
//        ///findByName quickTest
//        Item[] temp3 = trackersql.findByName("Inner mail");
//        for (Item i : temp3) {
//            System.out.println(i);
//        }
//        System.out.println("Длина массива найденых item's");
//        System.out.println(temp3.length);
//
//        System.out.println("==== findBy Id ====");
//
//
//        ///findByName quickTest
//        Item finded = trackersql.findById("3");
//        System.out.println("Найдено: " + finded);
//
//
//        // delete test
//        System.out.println();
//        System.out.println("============");
//        trackersql.delete("7");
//
//        for (Item i : temp) {
//            System.out.println(i);
//        }


    }
}






