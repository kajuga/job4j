package ru.job4j.sorting;

import java.util.*;

/**
 * SortUser - сортировщик юзеров.
 *
 * @author Fedorov Aleksander (msg2fedorov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SortUser {

    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }

    public List<User> sortNameLength(List<User> list) {
        Collections.sort(list, new CompName());
        return list;
    }

    public List<User> sortByAllFields(List<User> list) {
        Collections.sort(list, new CompNameAndAge());
        return list;
    }

    /**
     * Сравнивает по длине строки
     */
    static class CompName implements Comparator<User> {
        @Override
        public int compare(User a, User b) {
            return a.name.length() - b.name.length();
        }
    }

    /**
     * Сравнивает лексикографически, затем по возрасту
     */
    static class CompNameAndAge implements Comparator<User> {
        @Override
        public int compare(User user, User t1) {
            int res = user.name.compareTo(t1.name);
            if (res == 0) {
                res = user.age - t1.age;
            }
            return res;
        }
    }
}