package ru.job4j.userstorage;

import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aleksandr Fedorov(msg2fedorov@gmzil.com).
 * User storage with money transfer feature realisation.
 */
@ThreadSafe
public class UserStorage {
    private volatile Map<Integer, User> users = new HashMap<>();

    /**
     * add any user'
      * @param user - added user
     * @return
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
     * edit any user.
     * @param user - edited user.
     * @return
     */
    public synchronized boolean update(User user) {
        boolean result = false;
        if (userCheck(user)) {
            users.put(user.getId(), user);
            result = true;
        }
        return result;
    }

    /**
     * delete user.
     * @param user - deleting user.
     * @return
     */
    public synchronized boolean delete(User user) {
        boolean result = false;
        if (userCheck(user)) {
            users.remove(user.getId());
            result = true;
        }
        return result;
    }

    /**
     * transfer money from one user to other with cashcecking.
     * @param fromId from
     * @param toId  to
     * @param cash how mutch
     * @return boolean
     */
    public synchronized boolean transfer(Integer fromId, Integer toId, Integer cash) {
        boolean result = false;
        if (users.containsKey(fromId) && users.containsKey(toId)) {
            if (users.get(fromId).getAmount() > cash) {
                users.get(fromId).setAmount(users.get(fromId).getAmount() - cash);
                users.get(toId).setAmount(users.get(toId).getAmount() + cash);
                result = true;
            }
        }
        return result;
    }

    /**
     * simple user checker.
     * @param user user
     * @return boolean
     */
    public boolean userCheck(User user) {
        return users.containsKey(user.getId());
    }

    /**
     * how much money has any user informer.
     * @param user user for getting money info.
     * @return money.
     */
    public int moneyObserver(User user) {
        int result = 0;
        if (userCheck(user)) {
            result = users.get(user.getId()).getAmount();
        }
        return result;
    }
}

        