package ru.job4j.tracker;

import java.io.IOException;

/**
 * Проверка ключа на вхождение в диапазон массива int[] range
 * теперь с возможностью подсунуть свой input для теста
 */
public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) throws IOException {
        return this.input.ask(question);
    }

    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.ask(question, range);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Incorrect value. Please enter correct value: ");

            } catch (MenuOutException nfe) {
                System.out.println("Please enter correct value from 0-5: ");
            }
        } while (invalid);
        return value;
    }
}