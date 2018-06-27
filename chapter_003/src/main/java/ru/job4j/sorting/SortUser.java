package ru.job4j.sorting;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {

    public Set<User> sort (List <User> list){
        Set<User> users = new TreeSet<>();
        while (!list.isEmpty()){
            users.add((User) list);
        }
        return users;
    }
}