package ru.job4j.loop;

public class Factorial {

    public int calc(int n) {
        int temp = 1;
        for (int i = n; i > 0; i--) {
            temp *= i;
        }
        return temp;
    }
}
