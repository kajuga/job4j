package ru.job4j.statistics;

import java.util.Objects;

public class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /**
     * Переопределяю ручками hashCode юзера.
     * @return переопределенный хешкод
     */
    @Override
    public int hashCode() {
        int hash = 17;
        hash = 37 * hash + id;
        hash = 37 * hash + (name == null ? 0 : name.hashCode());
        return hash;
    }

    /**
     * Переопределяю ручками equals юзера.
     * на 0 явно не проверял, equals и так в этом случае вернет false;
     * @param o - ссылка на сравниваемый объект.
     * @return result
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof User) {
            User user = (User) o;
            return (Objects.equals(name, user.getName()) && Objects.equals(id, user.getId()));
        }
        return false;
    }
}