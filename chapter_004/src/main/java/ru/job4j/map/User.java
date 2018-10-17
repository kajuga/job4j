package ru.job4j.map;

import java.util.Calendar;

/**
 * User class realisation.
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 */
public class User {
    private String name;
    private int children;
    private Calendar birthday;

    /**
     * Конструктор User.
     * @param name
     * @param children
     * @param birthday
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    /**
     * Метод getName.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Метод getChildren.
     * @return children
     */
    public int getChildren() {
        return children;
    }

    /**
     * Метод getBirthday.
     * @return birthday
     */
    public Calendar getBirthday() {
        return birthday;
    }
}
