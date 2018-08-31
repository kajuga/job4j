package ru.job4j.loop;

/**
 * @Fedorov Aleksandr (msg2fedorov@gmail.com)
 * метод производит вычисление факуториала числа - произведение всех неотрицательных чисел от 1 до искомого числа
 */

public class Factorial {

    public int calc(int n) {
        int temp = 1;
        for (int i = n; i > 0; i--) {
            temp *= i;
        }
        return temp;
    }
}
