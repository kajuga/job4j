package ru.job4j.bank;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class BankTest {

    /**
     * Получаем список аккаунтов user'a
     * @throws Exception
     */
    @Test
    public void getUserAccount() throws Exception {
        Bank bank = new Bank();
        Account accountOne = new Account("333/444", 500.00);
        User userOne = new User("2Pac", "AUE1971");
        bank.addUser(userOne);
        bank.addAccountToUser(userOne.getId(), accountOne);
        List<Account> result = bank.getUserAccount("AUE1971");
        List<Account> expected = new ArrayList <>();
        expected.add(accountOne);
        Assert.assertEquals(result, expected);
    }

    /**
     * Проверка добавления user'a, account'a и получения account'a user'a по ID юзера.
     * @throws Exception
     */
    @Test
    public void getAccById() throws Exception {
        Bank bank = new Bank();
        Account accountOne = new Account("333/444", 500.00);
        User userOne = new User("2Pac", "AUE1971");
        bank.addUser(userOne);
        bank.addAccountToUser(userOne.getId(), accountOne);
        Double result = (bank.getAccById("AUE1971", "333/444")).getCash();
        Double expected = 500.00;
        Assert.assertEquals(result, expected);
    }

    /**
     * Проверка трансфера денег с одного счета на другой.
     * @throws Exception
     */
    @Test
    public void whenOneTransferMoneyTother() throws Exception {
        Bank bank = new Bank();
        User userOne = new User("2Pac", "AUE1971");
        Account accountOne = new Account("333/444", 500.00);
        bank.addUser(userOne);
        bank.addAccountToUser(userOne.getId(), accountOne);
        User userTwo = new User("Jamie Lee Curtis", "JLC1958");
        Account accountTwo = new Account("111/222", 200.00);
        bank.addUser(userTwo);
        bank.addAccountToUser(userTwo.getId(), accountTwo);
        boolean result = bank.transferMoney("AUE1971", "333/444", "JLC1958", "111/222", 100.00);
        boolean expected = true;
        Assert.assertTrue(result == expected && accountOne.getCash() == 400.00 && accountTwo.getCash() == 300.00);
        Assert.assertTrue(result == expected && accountOne.writeOff(100.00) && accountTwo.refill(100.00));
    }

    /**
     * Проверка трансфера денег с одного счета на другой (*при недостатке средств на счете-доноре)
     * @throws Exception
     */
    @Test
    public void whenOneTransferMoneyTotherButNotHaveEnoughMoney() throws Exception {
        Bank bank = new Bank();
        User userOne = new User("2Pac", "AUE1971");
        Account accountOne = new Account("333/444", 100.00);
        bank.addUser(userOne);
        bank.addAccountToUser(userOne.getId(), accountOne);
        User userTwo = new User("Jamie Lee Curtis", "JLC1958");
        Account accountTwo = new Account("111/222", 200.00);
        bank.addUser(userTwo);
        bank.addAccountToUser(userTwo.getId(), accountTwo);
        boolean result = bank.transferMoney("AUE1971", "333/444", "JLC1958", "111/222", 101.00);
        boolean expected = false;
        Assert.assertTrue(result == expected && accountOne.getCash() == 100.00 && accountTwo.getCash() == 200.00);
    }
}