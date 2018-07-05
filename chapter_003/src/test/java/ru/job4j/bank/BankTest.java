package ru.job4j.bank;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class BankTest {
    @Test
    public void whenOneTransferMoneyTother() throws Exception {
        Bank bank = new Bank();
        Map<User, List<Account>> users = new HashMap<>();
        User userOne = new User("2Pac", "AUE1971");
        Account accountOne = new Account("333/444", 500.00);
        List<Account> listAccOne = new ArrayList <>();
        listAccOne.add(accountOne);
        users.put(userOne, listAccOne);

        User userTwo = new User("Jamie Lee Curtis", "JLC1958");
        List<Account> listAccTwo = new ArrayList<>();
        Account accountTwo = new Account("111/222", 200.00);
        listAccTwo.add(accountTwo);
        users.put(userTwo, listAccTwo);

        boolean result = bank.transferMoney("AUE1971", "333/444", "JLC1958", "111/222", 100.00);
        boolean expected = true;
        Assert.assertTrue(result == expected && accountOne.getCash() == 400.00 && accountTwo.getCash() == 300.00);
    }
}