package ru.job4j.nonblockingcache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 * Nonblocking cash for models storage realisation
 */
public class NonBlockingCache {
    private Map<Integer, Base> hashCash = new ConcurrentHashMap<>();

    /**
     * adds model
     * @param model
     */
    public void add(Base model) {
        hashCash.putIfAbsent(model.getId(), model);
    }

    /**
     * udate model
     * @param model
     * @throws OptimisticException
     */
    public void update(Base model) throws OptimisticException {
        hashCash.computeIfPresent(model.getId(), (key, value) ->  {
            if (hashCash.get(key).getVer() == model.getVer()) {
                model.countVersion();
                return model;
            } else {
                throw new OptimisticException();
            }
        });
    }

    /**
     * get model by id
     * @param id
     * @return
     */
    public Base getModel(int id) {
        return hashCash.get(id);
    }

    /**
     * delete model
     * @param model
     * @return
     */
    public boolean delete(Base model) {
        boolean result = false;
        if (hashCash.containsKey(model.getId())) {
            hashCash.remove(model.getId());
            result = true;
        }
        return result;
    }

}