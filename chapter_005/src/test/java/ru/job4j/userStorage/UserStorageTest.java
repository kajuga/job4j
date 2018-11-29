package ru.job4j.userStorage;

import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStorageTest {
    private UserStorage userStorage = new UserStorage();
    User user1 = new User(111, 5000);
    User user2 = new User(222, 2000);
    User user3 = new User(333, 8000);
    User user4 = new User(444, 3000);
    User user5 = new User(555, 9000);

    @Test
    public void whenAddFourUsersThenDeleteThreeOfThem() {
        assertTrue(userStorage.add(user1));
        assertTrue(userStorage.userCheck(user1));
        assertFalse(userStorage.userCheck(user2));
        assertTrue(userStorage.add(user2));
        assertTrue(userStorage.userCheck(user2));
        assertTrue(userStorage.add(user4));
        assertTrue(userStorage.add(user3));
//deleting 3 users here
        assertTrue(userStorage.delete(user3));
        assertTrue(userStorage.delete(user1));
        assertTrue(userStorage.delete(user2));
        assertFalse(userStorage.userCheck(user2));
        assertTrue(userStorage.userCheck(user4));
        assertFalse(userStorage.userCheck(user5));
    }

        @Test
        public void whenAddTwoUsersAndAskHowMoneyTheyHave() {
        assertTrue(userStorage.add(user1));
        assertTrue(userStorage.add(user5));
        assertThat(userStorage.moneyObserver(user1), is(5000));
        assertThat(userStorage.moneyObserver(user5), is(9000));
        }

        @Test
        public void whenAddTwoUsersAndTransferMoneyFromFirstToSecondUserAccount() {
        assertTrue(userStorage.add(user1));
        assertTrue(userStorage.add(user5));
        assertThat(userStorage.moneyObserver(user1), is(5000));
        assertThat(userStorage.moneyObserver(user5), is(9000));
        assertThat(userStorage.transfer(111, 555, 888), is(true));
        assertThat(userStorage.moneyObserver(user1), is(4112));
        assertThat(userStorage.moneyObserver(user5), is(9888));
        }
}


