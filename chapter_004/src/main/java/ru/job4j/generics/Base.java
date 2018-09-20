package ru.job4j.generics;

/**
 * @author Fedorov Aleksander (msg2fedorov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public abstract class Base {

    /**
     * @param id Declares private parameter id.
     */
    private final String id;

    /**
     * Constructor Base.
     * @param idenfificator return id
     */
    protected Base(final String idenfificator) {
        this.id = idenfificator;
    }

    /**
     * Returns id.
     * @return id
     */
    public final String getId() {
        return this.id;
    }
}
