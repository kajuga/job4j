package ru.job4j.map;

import org.junit.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {
    /**
     * Добавляю двух юзеров с одинаковыми полями (не переопределяя hashcode() и equals()) в hashMap'у + проверка добавления, * value - некие Object's, не суть важно что в них.
     * результат = 2 объекта с разными адресами памяти, соответственно - false при сравнении 2 *ихних* хешей и false при сравнении equals() ссылок на эти объекты.
     */

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

    /**
     * Добавляю двух юзеров с переопределенным хешкодом, не переопределив equals
     * по прежнему получаю 2-х разных "одинаковых" юзеров на этот раз с одинаковым хэш кодом, что собственно
     * не противоречит принципу *2 разных объекта могут иметть одинаковый хэш (коллизия), но по логике, которая мне нужна - это не разные объекты и в дальнейшем
     * мне нужно будет также переопределить equals().
     */
    @Test
    public void whenTwoSameUsersWithOverriverHashCodeOnly() {
        Calendar date = new GregorianCalendar(2000, Calendar.FEBRUARY, 12);
        UserHashOverrided userOne = new UserHashOverrided("Sashoker", 1, date);
        UserHashOverrided userTwo = new UserHashOverrided("Sashoker", 1, date);
        Map<User, Object> map = new HashMap <>();
        map.put(userOne, new Object());
        map.put(userTwo, new Object());
        assertThat(map.size(), is(2));
        assertThat(userOne.hashCode() == userTwo.hashCode(), is(true));
        assertThat(userOne.equals(userTwo), is(false));
    }

    /**
     * 4. Переопределить только equals
     * Добавляю в map двух юзеров с переопределенным equals(),  не переопределив hashCode();
     */
    @Test
    public void whenTwoSameUsersWithOverriverEqualsOnly() {
        Calendar date = new GregorianCalendar(2001, Calendar.FEBRUARY, 12);
        UserEqualsOverrided userOne = new UserEqualsOverrided("Sashoker", 1, date);
        UserEqualsOverrided userTwo = new UserEqualsOverrided("Sashoker", 1, date);
        Map<User, Object> map = new HashMap <>();
        map.put(userOne, new Object());
        map.put(userTwo, new Object());
        assertThat(map.size(), is(2));
        assertThat(userOne.hashCode() == userTwo.hashCode(), is(false));
        assertThat(userOne.equals(userTwo), is(true));
    }
}