package ru.job4j.map;

import java.util.Calendar;
import java.util.Objects;

/**
 * @author Aleksandr fedorov (msg2fedorov@gmail.com)
 * Переопределить только hashCode
 */

public class UserHashOverrided extends User {
    private String name;
    private int children;

    public UserHashOverrided(String name, int children, Calendar birthday) {
        super(name, children, birthday);
        this.name = name;
        this.children = children;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + name.hashCode();
        result = prime * result + children;
        return result;
    }
}