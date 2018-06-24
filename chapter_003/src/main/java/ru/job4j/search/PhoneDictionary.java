package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * PhoneDictionary - телефонный справочник
 *
 * @author Fedorov Aleksander (msg2fedorov@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class PhoneDictionary {
    private List <Person> persons = new ArrayList <Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List <Person> find(String key) {
        List <Person> result = new ArrayList <Person>();
        for (Person find : persons) {
            if (find.getName().toLowerCase().contains(key)
                    || (find.getSurname().toLowerCase().contains(key))
                    || ((find.getPhone().contains(key)))
                    || ((find.getAddress().contains(key)))) {
                result.add(find);
            }
        }
        return result;
    }
}