package ru.job4j.generics;

import java.util.Iterator;


/**
 * Class for store of objects extends Base.
 * @author Fedorov Aleksander (msg2fedorov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class AbstractStore<T extends Base> implements Store<T> {

    /**
     * Object for store.
     */
    private SimpleArray<T> simpleArray = new SimpleArray<>();

    /**
     * Method adds new element in container.
     * @param model value for adding in container.
     */
    @Override
    public void add(T model) {
        this.simpleArray.add(model);
    }


    /**
     * Method updates element in container by identifier.
     *
     * @param id value of identifier for the object, which'll be updated.
     * @param model new value for updating.
     * @return if element updates return true, else return false.
     */
    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        int index = 0;
        Iterator<T> iterator = simpleArray.iterator();
        while (iterator.hasNext()) {
            T role = iterator.next();
            index++;
            if (role != null && role.getId() != null && role.getId().equals(id)) {
                simpleArray.set(index, model);
                result = true;
            }
        }
        return result;
    }

    /**
     * Method deletes element from container by identifier.
     * @param id value of identifier for the object, which'll be deleted.
     */
    @Override
    public void delete(String id) {
        Iterator<T> iterator = simpleArray.iterator();
        while (iterator.hasNext()) {
            T result = iterator.next();
            if (result.getId().equals(id)) ;
            iterator.remove();
            break;
        }
    }

    /**
     * Method find element by index.
     * Method find element by index.
     * @param id index of element.
     * @return element by index.
     */
    @Override
    public T findById(String id) {
        T result = null;
        Iterator<T> iterator = simpleArray.iterator();
        while (iterator.hasNext()) {
            result = iterator.next();
            if (result.getId().equals(id)) {
                break;
            }
        }
        return result;
    }
}
