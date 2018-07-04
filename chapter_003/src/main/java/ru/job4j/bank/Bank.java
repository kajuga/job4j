package ru.job4j.bank;

import com.sun.javafx.collections.MappingChange;

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
        public List <Account> getUserAccount(String id) {
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
        public boolean TransferMoney(String sourceId, String sourceAccount, String destId, String destAccount, double remittance) {
            boolean check = false;
            if (sourceId != null && sourceAccount != null && destId != null && destAccount != null && remittance > 0) {
                Account accSrc = this.GetAccountById(sourceId, sourceAccount);
                Account accDest = this.GetAccountById(destId, destAccount);
                if (accSrc.getCash() >= remittance && accDest != null) {
                    accSrc.setCash(accSrc.getCash() - remittance);
                    accDest.setCash(accDest.getCash() + remittance);
                }
                check = true;
            }
            return check;
        }

        /**
        * Поиск конкретного account user'a по ID  и банк. реквизитам (int details)
        * @param id
        * @param details
        * @return
        */
        private Account GetAccountById(String id, String details){
            Account result = null;
            for (Map.Entry <User, List<Account>> entry : users.entrySet()){
                if (entry.getKey().getId().equals(id)){
                    for (Account account : entry.getValue()){
                        if (account.getDetails().equals(details)){
                            result = account;
                            break;
                        }
                    }
                }
            }
            return result;
        }
    }