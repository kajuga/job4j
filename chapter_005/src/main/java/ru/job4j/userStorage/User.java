package ru.job4j.userStorage;

/**
 * Class User
 */
public class User {
    private int id;
    private int amount;

    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAmount() {
        return this.amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }


}
