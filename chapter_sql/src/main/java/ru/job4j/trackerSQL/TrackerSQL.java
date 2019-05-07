package ru.job4j.trackerSQL;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Item;
import ru.job4j.uml_system.Comment;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class TrackerSQL implements ITracker, AutoCloseable {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/job4j_database";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private static final Logger log = LogManager.getLogger(TrackerSQL.class);

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

//    Connection connection;
//    PreparedStatement preparedStatement;

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            System.out.println("1");
            String sql = "SELECT * FROM tracker.item";
            System.out.println("2");
            Class.forName(JDBC_DRIVER);
            System.out.println("3");
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            System.out.println("4");
            statement = connection.createStatement();
            System.out.println("5");
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String comments = resultSet.getString("comments");
                Date date = resultSet.getDate("creation_date");

                System.out.println("=====================================");
                System.out.println("id " + id);
                System.out.println("name " + name);
                System.out.println("description " + description);
                System.out.println("comments " + comments);
                System.out.println("date " + date);
                System.out.println("=====================================");


            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Item add(Item item) {
        try(Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD)) {
            String sql = "INSERT INTO tracker.item (name, description, comments, creation_date) VALUES (?, ?, ?, {d ?})";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, );



        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void replace(String id, Item item) {

    }

    @Override
    public void delete(String id) {
        try(Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD)) {
            String sql = "DELETE FROM tracker.item WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.valueOf(id));
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Item[] findAll() {
        List<Item> items = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM tracker.item";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Item item = new Item();
                item.setId(String.valueOf(resultSet.getInt("id")));
                item.setName(resultSet.getString("name"));
                item.setDesc(resultSet.getString("description"));

                String sqlComments = "SELECT * FROM tracker.comment WHERE item_id = ?";
                PreparedStatement statementComments = connection.prepareStatement(sqlComments);
                statementComments.setString(1, item.getId());
                ResultSet resultSetComments = statement.executeQuery(sql);
//                List<String> comments = new ArrayList<>();
                while (resultSetComments.next()) {
                    String comment = resultSetComments.getString("имя_столбца_из_таблицы_комментов");
                }

                String description = resultSet.getString("description");
                Date date = resultSet.getDate("creation_date");
                String comment = resultSetComments.getString("имя_столбца_из_таблицы_комментов");
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items.toArray(new Item[items.size()]);
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