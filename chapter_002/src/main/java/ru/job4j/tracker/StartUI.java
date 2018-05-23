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
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}