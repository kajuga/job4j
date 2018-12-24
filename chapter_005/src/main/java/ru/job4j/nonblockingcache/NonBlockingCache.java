package ru.job4j.nonblockingcache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NonBlockingCache {
    private Map <Integer, Base> hashCash = new ConcurrentHashMap<>();

    public void add(Base model) {
        hashCash.putIfAbsent(model.getId(), model);
    }

    /**
     *
     * @param model
     * @throws OptimisticException
     */
    public void update(Base model) throws OptimisticException {
        hashCash.computeIfPresent(model.getId(), (key, value) ->  {
            if(hashCash.get(key).getVer() == model.getVer()) {
                model.countVersion();
                return model;
            } else {
                throw new OptimisticException();
            }
        });
    }

    public Base getModel(int id) {
        return hashCash.get(id);
    }


    public boolean delete(Base model) {
        boolean result = false;
        if (hashCash.containsKey(model.getId())) {
            hashCash.remove(model.getId());
            result = true;
        }
        return result;
    }

}