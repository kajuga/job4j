package ru.job4j.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void whenNotOverrideEqualsHashcodeAddTwoSameUsersTheyAddedAsTwoDifferentUsers() {
        Calendar date = new GregorianCalendar(2000, Calendar.FEBRUARY, 12);
        User userOne = new User("Sashok", 0, date);
        User userTwo = new User("Sashok", 0, date);
        Map<User, Object> map = new HashMap <>();
        map.put(userOne, new Object());
        map.put(userTwo, new Object());
        assertThat(map.size(), is(2));
        assertThat(userOne.hashCode() == userTwo.hashCode(), is(false));
        assertThat(userOne.equals(userTwo), is(false));
        System.out.println(map);
    }
}