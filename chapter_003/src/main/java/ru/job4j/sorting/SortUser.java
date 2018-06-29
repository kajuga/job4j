package ru.job4j.sorting;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {
    public Set <User> sort(List <User> list) {
        return new TreeSet <>(list);
    }


    //TODO определить Comparator для метода Collections.sort и отсортировать List<User> по длине имени.
    public List <User> sortNameLength(List <User> user) {

        return null;
    }

    //TODO определить Comparator для метода Collections.sort и отсортировать List<User> по обоим полям,
    // TODO сначала сортировка по имени в лексикографическом порядке, потом по возрасту.
    public List <User> sortByAllFields(List <User> users) {


        return null;
    }


}