package ru.job4j.sorting;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUserTest {

    @Test
    public void sortNameLength() throws Exception {
        SortUser sortUser = new SortUser();
        List<User> userList = new ArrayList<>();
        User user1 = new User("Ванькаааааа", 5);
        User user2 = new User("Санькаааа", 2);
        User user3 = new User("Манька", 7);
        userList.add(user2);
        userList.add(user1);
        userList.add(user3);
        Set<User> result = new TreeSet<>(sortUser.sortNameLength(userList));
        Set<User> expected = new TreeSet<>();
        expected.add(user3);
        expected.add(user2);
        expected.add(user1);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void sortByAllFields() throws Exception {
        SortUser sortUser = new SortUser();
        List<User> userList = new ArrayList<>();
        User user1 = new User("Ванькаааааа", 5);
        User user2 = new User("Ванькаааааа", 2);
        User user5 = new User("Ванькаааааа", 1);
        User user3 = new User("Манька", 7);
        User user4 = new User("Манька", 1);
        userList.add(user2);
        userList.add(user1);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        Set<User> result = new TreeSet<>(sortUser.sortNameLength(userList));
        Set<User> expected = new TreeSet<>();
        expected.add(user5);
        expected.add(user2);
        expected.add(user1);
        expected.add(user4);
        expected.add(user3);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void WhenAddThreeEqualThree() {
        SortUser sortUser = new SortUser();
        List<User> userList = new ArrayList<>();
        User user1 = new User("Ванька", 1);
        User user2 = new User("Санька", 5);
        User user3 = new User("Манька", 7);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        Set<User> result = new TreeSet<>(sortUser.sort(userList));
        Set<User> expected = new TreeSet<>();
        expected.add(user1);
        expected.add(user2);
        expected.add(user3);
        Assert.assertEquals(expected, result);
    }
}