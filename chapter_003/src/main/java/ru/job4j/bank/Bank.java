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
        for (User user: users.keySet()){
            if (user.getId().equals(id)){
                users.get(user).add(account);
                break;
            }
        }
    }

    /**
     * Получить список счетов user'a
     * @param id
     * @return
     */
    public List<Account> getUserAccount(String id) {
            List <Account> result = new ArrayList <>();
            for (User user : users.keySet()) {
                if (user.getId().equals(id)) {
//                    result = this.users.get(user);            //если мне нужен список счетов, то так правильнее, верно?
                    result = users.get(user);
                    break;
                }
            }
            return result;
        }

    /**
     * Переводит деньги с одного счета на другой
     * @return
     */
    public boolean TransferMoney(String sourceId, String sourceAccount, String destId, String destAccount, double
            remittance){
        Account accSrc = null;
        Account accDest = new Account();

    // 1. найти по sourseID счета чувака-донора +
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
    // 2. найти по sourceAccount у него это account +
            if (entry.getKey().getId().equals(sourceId)) {
                //тут хочу достать поле cash из одного аккаунта из списка List и сравнить его с ссуммой перечисления, проверить возможно ли или нет..
                 for (Account account: entry.getValue()){
                     if (Integer.parseInt(sourceAccount) == account.getAccount()){
                         accSrc = account;
                         break;
                     }
                 }
            }

        }
        // 3. сравнить количество бабок на аккаунте с передаваемой суммой (double remittance); -


        // 4. найти второго чувака по destId
        // 5. найти у него счет destAccount
        // 6. перевести ему бабки double remittance


//
//        return this.getUserAccount(sourceId).contains(sourceAccount)&&
//                this.getUserAccount(destId).contains(destAccount)



            //если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят) должен вернуть false.

            return false;
    }






}

