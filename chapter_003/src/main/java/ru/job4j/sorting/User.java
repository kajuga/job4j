package ru.job4j.sorting;

public class User implements Comparable {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Object obj) {
        User entry = (User) obj;
        int result = age - entry.age;
        if (result != 0) {
            return (int) result / Math.abs(result);
        }
        return 0;
    }
}
