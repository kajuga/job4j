package ru.job4j.trackersql;

import ru.job4j.tracker.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.function.Consumer;

/**
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 * Consumer realisation
 */

public class StartUI {

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

    /**
     * ...
     */
    private final Consumer<String> output;
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final ITracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, ITracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Основой цикл программы.
     */
    public void init() throws IOException {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, this.output);
        menu.fillActions();
        do {
            menu.show();
            int key = input.ask("Select: ", new int[]{0, 1, 2, 3, 4, 5});
            menu.select(key);

        } while (!"y".equals(this.input.ask("Exit? (y):")));
    }

    /**
     * Запуск программы.
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);) {
            new StartUI(new ValidateInput(new ConsoleInput()), new Trackersql(connection), System.out::println).init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}