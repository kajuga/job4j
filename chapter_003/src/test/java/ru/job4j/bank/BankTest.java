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
        User userOne = new User("Jamie Lee Curtis", "BUD15735");
        Account accountOne = new Account("111222", 31233.50);
        List<Account> listAccOne = new ArrayList <>();
        listAccOne.add(accountOne);
        users.put(userOne, listAccOne);

        User userTwo = new User("2Pac", "AUE17976");
        List<Account> listAccTwo = new ArrayList<>();
        Account accountTwo = new Account("333444", 5675.30);
        listAccOne.add(accountTwo);
        users.put(userTwo, listAccTwo);

        boolean result = bank.transferMoney("BUD15735", "accountOne", "AUE17976", "accountTwo", 100.00);
        boolean expected = true;
        Assert.assertTrue(result == expected && accountOne.getCash() == 31133.50 && accountTwo.getCash() == 5775.30);
    }

}