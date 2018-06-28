package ru.job4j.sorting;

public class User implements Comparable<User> {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User user) {
        return this.age - user.age;
    }
}