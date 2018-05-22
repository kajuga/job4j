package ru.job4j.tracker;

public class MenuOutException extends RuntimeException {

    /**
     * Костыль-самодельный исключатор.
     * @param message
     */

    public MenuOutException(String message) {
        super(message);
    }
}