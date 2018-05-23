package ru.job4j.tracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput implements Input {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String ask(String question) throws IOException {
        System.out.print(question);
        return reader.readLine();
    }

    /**
     * Проверка ключа на вхождение в диапазон значений, заданных массивом int[]range
     * @param question
     * @param range
     * @return
     */
    @Override
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