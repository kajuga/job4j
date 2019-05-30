package ru.job4j.magnit;

import ru.job4j.tracker.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StoreSQL implements AutoCloseable {
    private final Config config;
    private Connection connect;


    public StoreSQL(Config config) {
        this.config = config;
    }

    public void generate(int size) {
        try (Connection connection = DriverManager.getConnection(config.get("url"))) {
//            PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE entries (id INTEGER PRIMARY KEY, name VARCHAR (50));");
//            выполняем наш preparedStatement
//             preparedStatement.execute();

//            теперь давай генерируем 100 entry
            Entry[] array = new Entry[size];
            for(int i = 0; i < 100; i++){
                array[i] = new Entry();
            }

//            try (PreparedStatement preparedStatementEntry = connection.prepareStatement("ЗДЕСЬ SQL НА INSERT в таблицу entry")) {
            String sqlEntry = "INSERT INTO entries (name) VALUES (?)";
            try (PreparedStatement preparedStatementEntry = connection.prepareStatement(sqlEntry)) {
//                в цикле вствавь 100 разных объектов
                for (int i = 0; i < array.length; i++) {
                    preparedStatementEntry.setString(1, array[i].getName());
                    preparedStatementEntry.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //ДОБАВИМ НОВЫЙ МЕТОД В КОТОРОМ ВЫПОЛНИМ SELECT
    public List<Entry> findAll() {
        List<Entry> entries = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(config.get("url"));
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM entries";
            ResultSet res = statement.executeQuery(sql);
            while (res.next()) {
                Entry entry = new Entry();
                entry.setId(res.getInt("id"));
                entry.setName(res.getString(2));
                entries.add(entry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entries;
    }


    public List<Integer> load() {
        return Collections.EMPTY_LIST;
    }
    @Override
    public void close() throws Exception {
        if (connect != null) {
            connect.close();
        }
    }

    //ДОБАВИМ МЕТОД MAIN ДЛЯ ЗАПУСКА ПРОГРАММЫ
    public static void main(String[] args) {

        Config config = new Config();
        config.init();
        StoreSQL storeSql = new StoreSQL(config);
        storeSql.generate(100);
        System.out.println(storeSql.findAll());
    }
}