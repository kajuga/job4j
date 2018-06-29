package ru.job4j.sorting;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUserTest {
    @Test
    public void sort() throws Exception {
    }

    @Test
    public void sortNameLength() throws Exception {
    }

    @Test
    public void sortByAllFields() throws Exception {
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