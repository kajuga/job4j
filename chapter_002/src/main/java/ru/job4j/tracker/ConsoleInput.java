package ru.job4j.tracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput implements Input {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String ask(String question) throws IOException {
        System.out.print(question);
        return reader.readLine();
    }

    /**
     * переопределил ask под новые параметры - String вопрос  и числовое значение из набора значений массива int[] range
     * @param question
     * @param range
     * @return
     */
    public int ask(String question, int[] range) {
        int key = 0;
        try {
            key = Integer.valueOf(this.ask(question));
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Не в диапазоне");
        }
    }
}