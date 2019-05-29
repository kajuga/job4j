package ru.job4j.trackersql;

import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Tracker realisation
 */
public class Trackersql implements ITracker, AutoCloseable {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/job4j_database";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Item add(Item item) {
        String sqlItem = "INSERT INTO tracker.item (name, description, creation_date) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlItem, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, item.getName());
            preparedStatement.setString(2, item.getDesc());
            preparedStatement.setDate(3, new Date(item.getCreated()));
            preparedStatement.executeUpdate();
            int idItem = -1;
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                idItem = generatedKeys.getInt(1);
                item.setId(String.valueOf(idItem));
            }
            if (idItem != -1) {
                String sqlComments = "INSERT INTO tracker.comment (comment, item_id) VALUES (?, ?)";
                try (PreparedStatement preparedStatementComments = connection.prepareStatement(sqlComments)) {
                    String[] itemComments = item.getComments();
                    for (String s : itemComments) {
                        preparedStatementComments.setString(1, s);
                        preparedStatementComments.setInt(2, idItem);
                        preparedStatementComments.executeUpdate();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public void replace(String id, Item item) {
        String sqlItem = "UPDATE tracker.item SET name = ?, description = ?, creation_date = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
             PreparedStatement preparedStatementItem = connection.prepareStatement(sqlItem)) {

            preparedStatementItem.setString(1, item.getName());
            preparedStatementItem.setString(2, item.getDesc());
            preparedStatementItem.setDate(3, new Date(item.getCreated()));
            preparedStatementItem.setInt(4, Integer.valueOf(id));
            preparedStatementItem.executeUpdate();

            String oldCommentsErase = "DELETE FROM tracker.comment WHERE item_id = ?";
            try (PreparedStatement preparedStatementoldCommentsErase = connection.prepareStatement(oldCommentsErase);) {
                preparedStatementoldCommentsErase.setInt(1, Integer.valueOf(id));
                preparedStatementoldCommentsErase.executeUpdate();
            }


            String sqlComments = "INSERT INTO tracker.comment (comment, item_id) VALUES (?, ?)";
            try (PreparedStatement preparedStatementComments = connection.prepareStatement(sqlComments)) {
                String[] itemComments = item.getComments();
                for (String s : itemComments) {
                    preparedStatementComments.setString(1, s);
                    preparedStatementComments.setInt(2, Integer.valueOf(id));
                    preparedStatementComments.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Удаление карточик по id
     * @param id
     */
    @Override
    public void delete(String id) {
        PreparedStatement preparedStatement = null;
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD)) {
            String sqlCommit = "DELETE FROM tracker.comment WHERE item_id = ?";
            preparedStatement = connection.prepareStatement(sqlCommit);
            preparedStatement.setInt(1, Integer.valueOf(id));
            preparedStatement.executeUpdate();
            String sqlItem = "DELETE FROM tracker.item WHERE id = ?";
            preparedStatement = connection.prepareStatement(sqlItem);
            preparedStatement.setInt(1, Integer.valueOf(id));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Find ALL
     * @return
     */
    @Override
    public Item[] findAll() {
        List<Item> items = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM tracker.item";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Item item = new Item();
                item.setId(String.valueOf(resultSet.getInt("id")));
                item.setName(resultSet.getString("name"));
                item.setDesc(resultSet.getString("description"));
                item.setCreated(resultSet.getDate(4).getTime());
                String sqlComments = "SELECT comment FROM tracker.comment WHERE item_id = ?";
                PreparedStatement statementComments = connection.prepareStatement(sqlComments);
                statementComments.setInt(1, Integer.valueOf(item.getId()));
                ResultSet resultSetComments = statementComments.executeQuery();
                List<String> comments = new ArrayList<>();
                while (resultSetComments.next()) {
                    String comment = resultSetComments.getString("comment");
                    item.setComments(comments.toArray(new String[comments.size()]));
                    comments.add(comment);
                }
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items.toArray(new Item[items.size()]);
    }

    /**
     * Find by name realisation
     * @param key
     * @return
     */
    @Override
    public Item[] findByName(String key) {
        List<Item> items = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM tracker.item WHERE name = " + "'" + key + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Item item = new Item();
                item.setId(String.valueOf(resultSet.getInt(1)));
                item.setName(resultSet.getString(2));
                item.setDesc(resultSet.getString(3));
                item.setCreated(resultSet.getDate(4).getTime());

                String sqlComments = "SELECT comment FROM tracker.comment WHERE item_id = " + item.getId();
                try (Statement statementComments = connection.createStatement()) {
                    ResultSet resultSetComments = statementComments.executeQuery(sqlComments);

                    List<String> comments = new ArrayList<>();
                    while (resultSetComments.next()) {
                        String comment = resultSetComments.getString("comment");
                        comments.add(comment);
                    }
                    item.setComments(comments.toArray(new String[comments.size()]));
                }
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items.toArray(new Item[items.size()]);
    }

    /**
     * Find Item by ID
     * @param id
     * @return
     */
    @Override
    public Item findById(String id) {
        Item item = new Item();
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM tracker.item WHERE id = " + "'" + id + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                item.setId(String.valueOf(resultSet.getInt(1)));
                item.setName(resultSet.getString(2));
                item.setDesc(resultSet.getString(3));
                item.setCreated(resultSet.getDate(4).getTime());
                String sqlComments = "SELECT comment FROM tracker.comment WHERE item_id = " + item.getId();
                try (Statement statementComments = connection.createStatement()) {
                    ResultSet resultSetComments = statementComments.executeQuery(sqlComments);
                    List<String> comments = new ArrayList<>();
                    while (resultSetComments.next()) {
                        String comment = resultSetComments.getString("comment");
                        comments.add(comment);
                    }
                    item.setComments(comments.toArray(new String[comments.size()]));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public void close() throws Exception {

    }
}