package ru.job4j.nonblockingcache;

public class OptimisticException extends RuntimeException {

    public OptimisticException() {
        System.out.println("wrong vesion");
    }
}