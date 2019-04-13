package ru.job4j.trackerSQL;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Item;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class TrackerSQL implements ITracker, AutoCloseable {
    private static final Logger log = LogManager.getLogger(TrackerSQL.class);

    private Connection connection;

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/job4j_database";
        String username = "postgres";
        String password= "postgres";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
             if (conn != null) {
                 try {
                     conn.close();
                 } catch (SQLException e) {
                    log.error(e.getMessage(), e);
                 }
             }
        }
        System.out.println(conn);

    }


    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }


    @Override
    public Item add(Item item) {
        return null;
    }

    @Override
    public void replace(String id, Item item) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Item[] findAll() {
        return new Item[0];
    }

    @Override
    public Item[] findByName(String key) {
        return new Item[0];
    }

    @Override
    public Item findById(String id) {
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}