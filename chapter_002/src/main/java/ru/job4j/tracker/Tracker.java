package ru.job4j.tracker;

import java.util.*;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {

    /**
     * Указатель ячейки для новой заявки.
     */
    private static final Random RN = new Random();

    /**
     * Массив для хранения заявок.
     */
//    private final Item[] items = new Item[100];
    private final List<Item> items = new ArrayList(100);


    /**
     * Начальная позиция первой заявки
     */
    private int position = 0;


    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId(item));
//        this.items[this.position++] = item;
        this.items.add(item);
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId(Item item) {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Метод меняет содержимое ячейки, найденной по полю "id" на содержимое переданного item.
     *
     * @param id   Уникальный id, генерируемый методом generatedId.
     * @param item Новое содержимое ячейки.
     */
    public void replace(String id, Item item) {
        Item replaser = findById(id);
        replaser.setName(item.getName());
        replaser.setDesc(item.getDesc());
        replaser.setCreated(item.getCreated());
        replaser.setComments(item.getComments());
    }

    /**
     * Метод удаляет ячейку в массиве this.items по уникальному id ключу.
     *
     * @param id Поле-ключ ячейки this.items.
     */
    public void delete(String id) {
        int index = Arrays.asList(this.items).indexOf(findById(id));
//        if (index >= 0 && index < this.items.length) {
        if (index >= 0 && index < this.items.size()) {
//            this.items[index] = null;
            this.items.clear();
        }
    }

    /**
     * Метод public Item[] findAll() возвращает копию массива this.items без null элементов.
     *
     * @return Возвращаемый массив без null;
     */
    public ArrayList<Item> findAll() {
        ArrayList<Item> result = new ArrayList <>();
        int count = 0;
        for (Item item : this.items) {
            if (item != null) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Метод возвращает результирующий массив элементов по ключу "name".
     *
     * @param key поле "name" по которому производится поиск ячейки в this.items.
     * @return
     */
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> temp = new ArrayList <>();
        int count = 0;
        for (Item item : this.items) {
            if (item != null && item.getName() != null && item.getName().equals(key)) {
                temp.add(item);
            }
        }
        ArrayList<Item> result = new ArrayList <>();
        System.arraycopy(temp, 0, result, 0, count);
        return result;
    }

    /**
     * Метод проверяет в цикле все элементы массива this.items,
     * сравнивая id с аргументом String id и возвращает найденный Item.
     *
     * @param id
     * @return
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}