package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {

    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет user
     * @param user
     */
    public void addUser (User user){
        this.users.put(user, new ArrayList <Account>());
    }

    /**
     * Удаляет user
     * @param user
     */
    public void deleteUser(User user){
        this.users.remove(user);
    }

    /**
     * Добавляет Account для user
     * @param id
     * @param account
     */
    public void addAccountToUser(String id, Account account){
        User user = new User(id);

        for(Map.Entry entry: users.entrySet()) {
            entry.getKey().equals(id); //херня какая то
//найти юзера с полем id

// добавить в List<Account> еще один account


        }


    }

    /**
     * Получить список счетов user'a
     * @param id
     * @return
     */
        public List<Account> getUserAccount (String id){
        return null;
    }

    /**
     * Переводит деньги с одного счета на другой
     * @return
     */
    public boolean TransferMoney (String sourceId, String sourceAccount, String destId, String destAccount, double
            remittance){

            //если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят) должен вернуть false.

            return false;
    }
}
