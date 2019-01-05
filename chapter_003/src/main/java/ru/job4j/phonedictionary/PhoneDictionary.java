package ru.job4j.phonedictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The phone dictionary.
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    /**
     * Add a person in list.
     * @param person - person.
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * find a person by any key with stream and other funny stuff.
     * @param key
     * @return
     */
    public List<Person> find(String key) {
        return this.persons.stream()
                .filter(p -> p.getName().contains(key) || p.getAddress().contains(key) || p.getPhone().contains(key) || p.getSurname().contains(key))
                .collect(Collectors.toList());
    }
}