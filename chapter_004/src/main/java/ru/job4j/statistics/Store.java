package ru.job4j.statistics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Регистратор изменений в списке юзеров.
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com).
 */

public class Store {

    public static Info differences(List <User> previous, List <User> current) {
        int added = 0;
        int changed = 0;
        int deleted = 0;

        Map<Integer, String> userMap = new HashMap<> (current.size());
        for (User user : current) {
            userMap.put(user.getId(), user.getName());
        }
        for (User prev : previous) {
            if(!userMap.containsKey(prev.getId())) {
                deleted++;
            }
            else if (!prev.getName().equals(userMap.get(prev.getId()))) {
                changed++;
            }
        }
        added = current.size() - (previous.size() - deleted);
        return new Info(added, changed, deleted);
    }
}