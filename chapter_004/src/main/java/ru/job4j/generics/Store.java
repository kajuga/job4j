package ru.job4j.generics;

/**
 * @author Fedorov Aleksander (msg2fedorov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public interface Store<T extends Base> {

    void add(T model);

    boolean replace(String id, T model);

    void delete(String id);

    T findById(String id);
}