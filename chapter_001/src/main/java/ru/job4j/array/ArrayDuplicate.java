package ru.job4j.array;

import java.util.Arrays;

/**
 * @author Alekasandr Fedorov (msg2fedorov@gmail.com)
 * Удаляем дубликаты в массиве
 */
public class ArrayDuplicate {

    /**
     * @param array Переданный в качестве аргумента массив
     * @return возвращает массив без дубликатов
     */
    public String[] remove(String[] array) {
        int countReshuffle = 0;
        for (int i = 0; i < array.length - countReshuffle; i++) {
            for (int j = i + 1; j < array.length - countReshuffle;) {
                if (comparison(array[i], (array[j]))) {
                    if (comparison(array[i], array[array.length - countReshuffle - 1])) {
                        countReshuffle++;
                    } else {
                        String temp = array[array.length - countReshuffle - 1];
                        array[array.length - countReshuffle - 1] = array[i];
                        array[j] = temp;
                        countReshuffle++;
                        j++;
                    }
                } else {
                    j++;
                }
            }
        }

        return Arrays.copyOf(array, (array.length - countReshuffle));
    }

    public boolean comparison(String str1, String str2) {
        return str1.equals(str2);
    }
}

