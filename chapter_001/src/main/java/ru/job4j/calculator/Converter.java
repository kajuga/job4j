package ru.job4j.calculator;

/**
 * Корвертор валюты.
 */
public class Converter {

    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        if (value > 0) {
            return value / 70;
        }
        else {
            return 0;
        }
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллоры.
     */
    public int rubleToDollar(int value) {
        if (value > 0) {
            return value / 60;
        }
        else {
            return 0;
        }
    }

    /**
     * Конвертируем евро в рубли.
     * @param value евро.
     * @return Рубли.
     */
    public int euroToRuble(int value) {
        if (value > 0) {
            return value * 70;
        }
        else {
            return 0;
        }
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return Рубли.
     */
    public int dollarToRuble(int value) {
        if (value > 0) {
            return value * 60;
        }
        else {
            return 0;
        }
    }
}
