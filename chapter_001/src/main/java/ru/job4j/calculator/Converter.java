package ru.job4j.calculator;

/**
 * Корвертор валюты.
 */
public class Converter {

    /**
     * Конвертируем рубли в евро.
     *
     * @param value рубли.
     * @return Евро.
     */
    public double rubleToEuro(double value) {
        return validate(value) / 60;
    }

    /**
     * Конвертируем рубли в доллары.
     *
     * @param value рубли.
     * @return Доллоры.
     */
    public double rubleToDollar(double value) {
        return validate(value) / 60;
    }

    /**
     * Конвертируем евро в рубли.
     *
     * @param value евро.
     * @return Рубли.
     */
    public double euroToRuble(double value) {
            return validate(value) * 70;
    }

    /**
     * Конвертируем доллары в рубли.
     *
     * @param value доллары.
     * @return Рубли.
     */
    public double dollarToRuble(double value) {
            return validate(value) * 60;
    }

    /**
     * Вынесенный в отдельный метод упрощенный валидатор.
     * @param value
     * @return
     */
    private double validate(double value) {
        return value < 0 ? 0 : value;
    }
}
