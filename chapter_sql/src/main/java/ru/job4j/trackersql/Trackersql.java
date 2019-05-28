package ru.job4j.trackersql;

import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Item;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

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
//        Item[] temp = trackersql.findAll();
//        for (Item i : temp) {
//            System.out.println(i);
//        }
//        Item itemNew = new Item("NewTestItem", "blablabla", LocalDate.of(2019, 5, 4).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
//        String [] tempComments = {"Первый коммент нового итема", "Второй коммент нового итема"};
//        itemNew.setComments(tempComments);
//        System.out.println("======");
//
//        //add test
//        trackersql.add(itemNew);
//        Item[] temp2 = trackersql.findAll();
//        for (Item i : temp2) {
//            System.out.println(i);
//        }

        //replace testing
        Item itemNew = new Item("NewTestItem", "blablabla", LocalDate.of(1945, 5, 9).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        String[] tempComments = {"Первый коммент нового-замененного итема", "Второй коммент нового-замененного итема"};
        itemNew.setComments(tempComments);
        System.out.println("======итем создан, ехаем дальше========");
        System.out.println();
        System.out.println("===замена пятого итема вот этим новым ========");
        trackersql.replace(String.valueOf(5), itemNew);

//        System.out.println("==== findByName ====");
//        ///findByName quickTest
//        Item[] temp3 = trackersql.findByName("Inner mail");
//        for (Item i : temp3) {
//            System.out.println(i);
//        }
//        System.out.println("Длина массива найденых item's");
//        System.out.println(temp3.length);
//
//        System.out.println("==== findBy Id ====");
//        ///findByName quickTest
//        Item finded = trackersql.findById("3");
//        System.out.println("Найдено: " + finded);


//        // delete test
//        System.out.println();
//        System.out.println("============");
//        trackersql.delete("7");
//
//        for (Item i : temp) {
//            System.out.println(i);
//        }

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
             PreparedStatement preparedStatementItem = connection.prepareStatement(sqlItem)){

            preparedStatementItem.setString(1, item.getName());
            preparedStatementItem.setString(2, item.getDesc());
            preparedStatementItem.setDate(3, new Date(item.getCreated()));
            preparedStatementItem.setInt(4, Integer.valueOf(id));
            preparedStatementItem.executeUpdate();

            String oldCommentsErase = "DELETE FROM tracker.comment WHERE item_id = ?";
            try(PreparedStatement preparedStatementoldCommentsErase = connection.prepareStatement(oldCommentsErase);) {
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
     *
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
     *
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
     *
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