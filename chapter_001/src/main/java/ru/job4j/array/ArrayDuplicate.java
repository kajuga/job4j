package ru.job4j.array;

import java.util.Arrays;

/**
 * @author Alekasandr Fedorov (msg2fedorov@gmail.com)
 * Удаляем дубликаты в массиве
 */
public class ArrayDuplicate {
    /**
     *
     * @param array Переданный в качестве аргумента массив
     * @return возвращает массив без дубликатов
     */
    public String[] remove(String[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length;) {
                if (array[i].equals(array[j])) {
                    String temp = array[array.length - 1];
                    array[array.length - 1] = array[j];
                    array[j] = temp;
                    array = Arrays.copyOf(array, array.length - 1);
                } else {
                    j++;
                }
            }
        }
        return array;
    }
}
