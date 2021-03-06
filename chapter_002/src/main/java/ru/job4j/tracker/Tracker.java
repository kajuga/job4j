package ru.job4j.tracker;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker implements ITracker {

    /**
     * Указатель ячейки для новой заявки.
     */
    private static final Random RN = new Random();

    /**
     * Массив для хранения заявок.
     */
    private final Item[] items = new Item[100];

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
    public boolean delete(String id) {
        int index = Arrays.asList(items).indexOf(findById(id));
        if (index >= 0 && index < items.length) {
            items[index] = null;
        }
        return true;
    }

    /**
     * Метод public Item[] findAll() возвращает копию массива this.items без null элементов.
     * Переделал на stream
     * @return Возвращаемый массив без null;
     */
    public Item[] findAll() {
        return Arrays.stream(items)
                .filter(p -> p != null)
                .toArray(Item[]::new);
    }

    /**
     * Метод возвращает результирующий массив элементов по ключу "name".
     *
     * @param key поле "name" по которому производится поиск ячейки в this.items.
     * @return
     */
    public Item[] findByName(String key) {
            return Arrays.stream(items)
                .filter(p -> p != null && p.getName() != null && p.getName().equals(key))
                .toArray(Item[]::new);

    }

    /**
     * Метод проверяет в цикле все элементы массива this.items,
     * сравнивая id с аргументом String id и возвращает найденный Item.
     * UPD Переделал на Stream
     *
     * @param id
     * @return
     */
    public Item findById(String id) {
        return  Arrays.stream(items)
                .filter(p -> p.getId().equals(id))
                .findAny().get();
    }
}