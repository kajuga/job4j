package ru.job4j.statistics;

/**
 * Class info with counters.
 */

public class Info {
    private int addCounter;
    private int changeCounter;
    private int delCounter;

    public Info(int addCounter, int changeCounter, int delCounter) {
        this.addCounter = addCounter;
        this.changeCounter = changeCounter;
        this.delCounter = delCounter;
    }

    public int getAddCounter() {
        return addCounter;
    }

    public int getChangeCounter() {
        return changeCounter;
    }

    public int getDelCounter() {
        return delCounter;
    }
}