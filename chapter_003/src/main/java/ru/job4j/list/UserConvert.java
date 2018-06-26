package ru.job4j.list;

import java.util.HashMap;
import java.util.List;

public class UserConvert {

    /**
     * Конвертация списка в Map с ключом Integer id и соответствующим ему User.
     * @author Fedorov Aleksander (msg2fedorov@gmail.com)
     * @version $Id$
     * @since 0.1
     */
    HashMap<Integer, User> process(List<User> list) {

        HashMap <Integer, User> mapUser = new HashMap <>();
        for (User i : list) {
            Integer key = i.getId();
            if (!mapUser.containsKey(key)) {
                mapUser.put(key, i);
            }
        }
        return mapUser;
    }
}