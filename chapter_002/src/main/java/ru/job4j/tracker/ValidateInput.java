package ru.job4j.tracker;

/**
 * Verification types of exception.
 */
public class ValidateInput extends ConsoleInput {
    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
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