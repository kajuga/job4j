package ru.job4j.map;

import java.util.Calendar;

/**
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com).
 * Резализация User с переопределенным методом equals().
 */

public class UserEqualsOverrided extends User{
    private String name;
    private int children;


    /**
     * Конструктор User.
     *
     * @param name
     * @param children
     * @param birthday
     */
    public UserEqualsOverrided(String name, int children, Calendar birthday) {
        super(name, children, birthday);
        this.name = name;
        this.children = children;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getChildren() {
        return children;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null)
        {
            return false;
        }
        if (o == this)
        {
            return true;
        }
        if (getClass() != o.getClass())
        {
            return false;
        }
        UserEqualsOverrided e = (UserEqualsOverrided) o;
        return (this.getName() == e.getName() && (this.getChildren() == getChildren()));
    }
}
