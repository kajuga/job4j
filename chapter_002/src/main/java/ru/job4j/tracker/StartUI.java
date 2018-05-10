package ru.job4j.tracker;

import java.io.IOException;

public class StartUI {
    private static final String ADD_NEW_ITEM = "0";
    private static final String SHOW_ALL_ITEMS = "1";
    private static final String EDIT_ITEM = "2";
    private static final String DELETE_ITEM = "3";
    private static final String FIND_ITEM_BY_ID = "4";
    private static final String FIND_ITEMS_BY_NAME = "5";
    private static final String EXIT = "6";
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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню: ");
            if (ADD_NEW_ITEM.equals(answer)) {
                this.createItem();
            } else if (SHOW_ALL_ITEMS.equals(answer)) {
                this.showItem();
            } else if (EDIT_ITEM.equals(answer)) {
                this.editItems();
            } else if (DELETE_ITEM.equals(answer)) {
                this.deleteItem();
            } else if (FIND_ITEM_BY_ID.equals(answer)) {
                this.findItemById();
            } else if (FIND_ITEMS_BY_NAME.equals(answer)) {
                this.findItemByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("Select: ");
    }

    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    private void createItem() throws IOException {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите desc заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует отображение всех заявок (с содержимым) в хранилище.
     */
    private void showItem() {
        System.out.println("------------ Вывод на экран списка имеющихся заявок --------------");
        Item[] result = this.tracker.findAll();
        for (Item items : result) {
            System.out.println(items.toString());
        }
    }

    /**
     * Метод реализует редактирование содержимого заявки (поиск по id заявки).
     */
    private void editItems() throws IOException {
        System.out.println("------------ Редактирование содержимого заявки --------------");
        String oldId = this.input.ask("Введите id редактируемой заявки: ");
        Item reversoItem = new Item();
        if (oldId != null) {
            if (reversoItem == null) {
                System.out.println("Указанного id не существует, введите корректный Id");
                editItems();
            }
                Item newItem = new Item();
                newItem.setName(this.input.ask("Введите новое имя заявки: "));
                String newDesc = this.input.ask("Введите новое desc заявки: ");
                newItem.setDesc(newDesc);
                Long newCreated = Long.valueOf(this.input.ask("Введите новое created заявки: "));
                newItem.setCreated(newCreated);
                String[] newComments = new String[]{this.input.ask("Введите комментарий к новой заявке: ")};
                newItem.setComments(newComments);
                tracker.replace(oldId, newItem);
                System.out.println("------------ Сохранение внесенных изменений... --------------");
                System.out.println("------------ Сохранение успешно завершено --------------");
            }
        }


    /**
     * Метод реализует удаление заявки из хранилища.
     */
    private void deleteItem() throws IOException {
        System.out.println("------------ Удаление заявки из хранилища --------------");
        String id = this.input.ask("Введите id заявки :");
        this.tracker.delete(id);
        System.out.println("------------ Заявка с Id : " + id + " удалена.");
    }

    /**
     * Метод реализует поиск/вывод на экран заявки по id.
     */
    private void findItemById() throws IOException {
        System.out.println("------------ Поиск заявки по id --------------");
        String id = this.input.ask("Введите id заявки :");
        Item item = this.tracker.findById(id);
        System.out.println("------------ Вывод на экран содержимого заявки: ");
        System.out.println("name: " + item.getName());
        System.out.println("desc: " + item.getDesc());
        System.out.println("created: " + item.getCreated());
        System.out.println("comments: " + item.getComments());
    }

    /**
     * Метод реализует поиск/вывод на экран заявки по name.
     */
    private void findItemByName() throws IOException {
        System.out.println("------------ Поиск заявки по name --------------");
        String name = this.input.ask("Введите name заявки :");
        Item[] item = this.tracker.findByName(name);
        System.out.println("------------ Вывод на экран содержимого заявки: ");
        for (Item it : item) {
            System.out.println(it);
            System.out.println("");
        }
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