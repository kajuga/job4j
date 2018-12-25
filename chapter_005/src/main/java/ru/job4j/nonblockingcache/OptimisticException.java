package ru.job4j.nonblockingcache;

public class OptimisticException extends RuntimeException {
    public OptimisticException() {
        super("Object was already modified");
    }
}