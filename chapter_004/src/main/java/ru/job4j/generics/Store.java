package ru.job4j.generics;

/**
 * @author Fedorov Aleksander (msg2fedorov@gmail.com)
 * @version $Id$
 * @since 0.1
 */

/**
 * Interface supply.
 * @param <T> declare generics
 */
public interface Store<T extends Base> {

    /**
     * add object to array.
     * @param model adds a model
     */
    void add(T model);

    /**
     *
     * @param id search by id.
     * @param model model for search
     * @return
     */
    boolean replace(String id, T model);


    /**
     * Delete elements.
     * @param id id of deleted element
     */
    void delete(String id);

    /**
     * Search by id in array.
     * @param id searched elements id
     * @return
     */
    T findById(String id);
}
