package ru.job4j.loop;

public class Counter {

    public int add(int start, int finish) {
        if (start % 2 != 0) {
            ++start;
        }
        if (finish % 2 != 0) {
            --finish;
        }
        return (finish * (finish + 2) - start * (start - 2)) / 4;
    }
}
