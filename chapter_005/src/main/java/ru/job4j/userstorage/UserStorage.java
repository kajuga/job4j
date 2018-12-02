package ru.job4j.userstorage;

import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;

@ThreadSafe
public class UserStorage {
    private volatile Map<Integer, User> users = new HashMap<>();

    /**
     * Addind user into storage
     */
    public synchronized boolean add(User user) {
        if (!userCheck(user)) {
            this.users.put(user.getId(), user);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Update user's amount
     */
    public synchronized boolean update(User user) {
        if (userCheck(user)) {
            this.users.put(user.getId(), new User(user.getId(), user.getAmount()));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Delete user from storage
     */
    public synchronized boolean delete(User user) {
        if (userCheck(user)) {
            users.remove(user.getId());
            return true;
        } else {
            return false;
        }
    }

    /**
     * Transfer money
     */
    public synchronized boolean transfer(int fromId, int toId, int amount) {
        boolean result = false;
        if (users.containsKey(fromId) && users.containsKey(toId)) {
            if (users.get(fromId).getAmount() > amount) {
                users.get(fromId).setAmount(users.get(fromId).getAmount() - amount);
                users.get(toId).setAmount(users.get(toId).getAmount() + amount);
                result = true;
            }
        } else {
            result = false;
        }
        return result;
    }

    /**
     * Проверка наличия usera в storage
     */
    public synchronized boolean userCheck(User user) {
        boolean result  = false;
        if (users.containsKey(user.getId())) {
            result =  true;
        }
        return result;
    }

    /**
     * Смотрю сколько денег на счету у юзера. с возвратом "0" некорректно, но что-нибудь придумаю.
     */
    synchronized int moneyObserver(User user) {
        if (userCheck(user)) {
            return users.get(user.getId()).getAmount();
        } else {
            return 0;
        }
    }
}