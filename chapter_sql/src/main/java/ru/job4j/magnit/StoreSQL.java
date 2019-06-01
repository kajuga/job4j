package ru.job4j.magnit;

import ru.job4j.magnit.entity.Entry;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StoreSQL implements AutoCloseable {
    private final Config config;
    private Connection connect;


    public StoreSQL(Config config) {
        this.config = config;
        try {
            this.connect = DriverManager.getConnection(config.get("url"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void generate(int size) {
//        close();
        try (PreparedStatement preparedStatement = connect.prepareStatement("CREATE TABLE IF NOT EXISTS entries (id INTEGER PRIMARY KEY, name VARCHAR (50));");){
            preparedStatement.execute();

//            теперь давай генерируем 100 entry
            Entry[] array = new Entry[size];
            for(int i = 0; i < 100; i++){
                array[i] = new Entry();
            }

//            try (PreparedStatement preparedStatementEntry = connection.prepareStatement("ЗДЕСЬ SQL НА INSERT в таблицу entry")) {
            String sqlEntry = "INSERT INTO entries (name) VALUES (?)";
            try (PreparedStatement preparedStatementEntry = connect.prepareStatement(sqlEntry)) {
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
    public void close() {
        if (connect != null) {
            try {
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}