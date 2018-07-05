package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Bank - перевод суммы со счета на счет
 * @author Fedorov Aleksander (msg2fedorov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
    public class Bank {
        private Map <User, List <Account>> users = new HashMap <>();

        /**
         * Добавляет user
         *
         * @param user
         */
        public void addUser(User user) {
            this.users.put(user, new ArrayList <Account>());
        }

        /**
         * Удаляет user
         *
         * @param user
         */
        public void deleteUser(User user) {
            this.users.remove(user);
        }

        /**
         * Добавляет Account для user
         *
         * @param id
         * @param account
         */
        public void addAccountToUser(String id, Account account) {
            for (User user : users.keySet()) {
                if (user.getId().equals(id)) {
                    users.get(user).add(account);
                    break;
                }
            }
        }

        /**
         * Получить список счетов user'a
         *
         * @param id
         * @return
         */
        public List<Account> getUserAccount(String id) {
            List <Account> result = new ArrayList <>();
            for (User user : users.keySet()) {
                if (user.getId().equals(id)) {
                    result = users.get(user);
                    break;
                }
            }
            return result;
        }

        /**
         * Переводит деньги с одного счета на другой
         *
         * @return
         */
        public boolean transferMoney(String sourceId, String sourceDetails, String destId, String destDetails, double
                remittance) {
            boolean check = false;
            if (sourceId != null && sourceDetails != null && destId != null && destDetails != null && remittance > 0) {
                Account accSrc = null;
                Account accDest = null;
                for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
                    if (entry.getKey().getId().equals(sourceId)) {
                        for (Account account : entry.getValue()) {
                            if (account.getDetails().equals(sourceDetails)) {
                                accSrc = account;
                                break;
                            }
                        }
                    }
                    if (entry.getKey().getId().equals(destId)) {
                        for (Account account : entry.getValue()) {
                            if (account.getDetails().equals(destDetails)) {
                                accDest = account;
                                break;
                            }
                        }
                    }
                }

                //вот тут косяк
                if (accSrc.getCash() >= remittance && accDest != null) {
                    accSrc.setCash(accSrc.getCash() - remittance);
                    accDest.setCash(accDest.getCash() + remittance);
                }
                check = true;
            }
            return check;
        }
    }

