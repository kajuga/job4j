package ru.job4j.tracker;

import java.io.IOException;

public class StartUI {
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() throws IOException {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.show();
            int key = Integer.valueOf(input.ask("Select: "));
            menu.select(key);

        } while (!"y".equals(this.input.ask("Exit? (y):")));
    }

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}