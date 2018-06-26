package ru.job4j.list;

import java.util.HashMap;
import java.util.List;

public class UserConvert {

    /**
     * В классе UserConvert написать метод public HashMap<Integer, User> process(List<User> list) {},
     * который принимает в себя список пользователей и конвертирует его в Map с ключом Integer id и соответствующим ему User.
     * @param list
     * @return
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
