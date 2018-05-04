package ru.job4j.tracker;

import java.util.*;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    private static final Random RN = new Random();


    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId(item));
        this.items[this.position++] = item;
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
        int index = Arrays.asList(items).indexOf(findById(id));
        if (index >= 0 && index < items.length) {
            items[index] = null;
        }
    }

    /**
     * Метод public Item[] findAll() возвращает копию массива this.items без null элементов.
     *
     * @return Возвращаемый массив без null;
     */
    public Item[] findAll() {
        Item[] result = new Item[items.length];
        int count = 0;
        for (Item item : this.items) {
            if (item != null) {
                result[count++] = item;
            }
        }
        return Arrays.copyOf(result, count);
    }

    /**
     * Метод возвращает результирующий массив элементов по ключу "name".
     *
     * @param key поле "name" по которому производится поиск ячейки в this.items.
     * @return
     */
    public Item[] findByName(String key) {
        Item[] temp = new Item[this.items.length];
        int count = 0;
        for (Item item : this.items) {
            if (item != null && item.getName() != null && item.getName().equals(key)) {
                temp[count++] = item;
            }
        }
        Item[] result = new Item[count];
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