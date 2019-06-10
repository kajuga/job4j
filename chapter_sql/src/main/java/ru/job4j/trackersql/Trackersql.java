package ru.job4j.trackersql;

import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Item;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Tracker realisation
 */
public class Trackersql implements ITracker, AutoCloseable {
    private Connection connection;

    public Trackersql(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Add realisation
     *
     * @param item
     * @return
     */
    @Override
    public Item add(Item item) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tracker.item (name, description, creation_date) "
                + "VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
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
                    if (itemComments != null) {
                        for (String s : itemComments) {
                            preparedStatementComments.setString(1, s);
                            preparedStatementComments.setInt(2, idItem);
                            preparedStatementComments.executeUpdate();
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    /**
     * Replace realisation
     *
     * @param id
     * @param item
     */
    @Override
    public void replace(String id, Item item) {
        try (PreparedStatement preparedStatementItem = connection.prepareStatement("UPDATE tracker.item SET "
                + "name = ?, description = ?, creation_date = ? "
                + "WHERE id = ?")) {
            preparedStatementItem.setString(1, item.getName());
            preparedStatementItem.setString(2, item.getDesc());
            preparedStatementItem.setDate(3, new Date(item.getCreated()));
            preparedStatementItem.setInt(4, Integer.valueOf(id));
            preparedStatementItem.executeUpdate();

            try (PreparedStatement preparedStatementoldCommentsErase = connection.prepareStatement("DELETE FROM tracker.comment WHERE item_id = ?");) {
                preparedStatementoldCommentsErase.setInt(1, Integer.valueOf(id));
                preparedStatementoldCommentsErase.executeUpdate();
            }
            try (PreparedStatement preparedStatementComments = connection.prepareStatement("INSERT INTO tracker.comment (comment, item_id) VALUES (?, ?)")) {
                String[] itemComments = item.getComments();
                if (itemComments != null) {
                    for (String s : itemComments) {
                        preparedStatementComments.setString(1, s);
                        preparedStatementComments.setInt(2, Integer.valueOf(id));
                        preparedStatementComments.executeUpdate();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Удаление карточек по id
     *
     * @param id
     */
    @Override
    public boolean delete(String id) {
        boolean result = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM tracker.comment WHERE item_id = ?")) {
            preparedStatement.setInt(1, Integer.valueOf(id));
            result = preparedStatement.executeUpdate() != 0;
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Find ALL
     *
     * @return
     */
    @Override
    public Item[] findAll() {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tracker.item")) {
            ResultSet resultSet = preparedStatement.executeQuery();
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
     *
     * @param key
     * @return
     */
    @Override
    public Item[] findByName(String key) {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tracker.item WHERE name = ?")) {
            preparedStatement.setString(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                items.add(buildItem(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items.toArray(new Item[items.size()]);
    }

    /**
     * Find Item by ID
     *
     * @param id
     * @return
     */
    @Override
    public Item findById(String id) {
        Item item = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tracker.item WHERE id = ?")) {
            preparedStatement.setInt(1, Integer.valueOf(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                item = buildItem(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    private Item buildItem(ResultSet resultSet) throws SQLException {
        Item item = new Item();
        item.setId(String.valueOf(resultSet.getInt(1)));
        item.setName(resultSet.getString(2));
        item.setDesc(resultSet.getString(3));
        item.setCreated(resultSet.getDate(4).getTime());
        item.setComments(getCommentsByItem(item.getId()));
        return item;
    }

    /**
     * Return all comments of item
     *
     * @param itemId
     * @return
     */
    private String[] getCommentsByItem(String itemId) {
        String sqlComments = "SELECT comment FROM tracker.comment WHERE item_id = " + itemId;
        try (Statement statementComments = connection.createStatement()) {
            ResultSet resultSetComments = statementComments.executeQuery(sqlComments);
            List<String> comments = new ArrayList<>();
            while (resultSetComments.next()) {
                String comment = resultSetComments.getString("comment");
                comments.add(comment);
            }
            return new String[comments.size()];
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new String[0];
    }
}