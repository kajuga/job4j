package ru.job4j.trackersql;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Item;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Trackersql implements ITracker, AutoCloseable {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/job4j_database";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
//    private static final Logger log = LogManager.getLogger(Trackersql.class);

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
//             BufferedReader sqlFile = new BufferedReader(new InputStreamReader(Trackersql.class.getClassLoader().getResourceAsStream("item-creator_MERGED.sql")));
//             Scanner scanner = new Scanner(sqlFile);
//             Statement statement = connection.createStatement()) {
//
//            String line = "";
//            while (scanner.hasNextLine()) {
//                line = scanner.nextLine();
//                if (line.endsWith(";")) {
//                    line = line.substring(0, line.length() - 1);
//                }
//                statement.executeUpdate(line);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Trackersql trackersql = new Trackersql();
        //select all testing
        Item[] temp = trackersql.findAll();
        for (Item i : temp) {
            System.out.println(i);

        }
        //delete test
//        System.out.println();
//        trackersql.delete("4");
//
//        for (Item i : temp) {
//            System.out.println(i);
//        }

    }

    @Override
    public Item add(Item item) {
        try(Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD)) {
            String sqlItem = "INSERT INTO tracker.item (name, description, creation_date) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlItem);
            preparedStatement.setString(1, item.getName());
            preparedStatement.setString(2, item.getDesc());
            preparedStatement.setDate(3, new Date(item.getCreated()));
            String sqlComments = "INSERT INTO tracker.comment (comment, item_id) VALUES (?, ?)";
//            preparedStatement.setString(1, );


            preparedStatement.executeUpdate();
//
//item.setCreated(resultSet.getDate(4).getTime());
//
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public void replace(String id, Item item) {

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
     * Поиск всех карточек
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