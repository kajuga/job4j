package ru.job4j.list;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class UserConvertTest {
    @Test
    public void whenChegotoTamThenCegotoTam() {
        UserConvert userConvert = new UserConvert();
        List listUser = new ArrayList();
        User user1 = new User(1, "Ванька", "Ленинград");
        User user2 = new User(2, "Санька", "Домодедово");
        User user3 = new User(3, "Саруман", "Мордор");
        listUser.add(user1);
        listUser.add(user2);
        listUser.add(user3);

        Map<Integer, User> result = userConvert.process(listUser);
        Map<Integer, User> expected = new HashMap <>();
        expected.put(user1.getId(), user1);
        expected.put(user2.getId(), user2);
        expected.put(user3.getId(), user3);


    }
}



