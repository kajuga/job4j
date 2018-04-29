package ru.job4j.array;

import java.util.Arrays;

/**
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 * Совокупление двух массивов произвольного размера в один с последующей сортировкой и удалением повторяющихся значений.
 */
public class ArrayHomeTask {

    public int[] getSortedArrayWithoutDubles(int[] array1, int[] array2) {
        int[] arraySumFinish = bubbleSort(noDuplicate(getUnitedArrayUniversal(array1, array2)));
        return arraySumFinish;
    }

    /**
     * Метод, объединяющий 2 переданных в него массива (просто логика).
     *
     * @param array1 Передаваемый для суммирования массив №1;
     * @param array2 Передаваемый для суммирования массив №2;
     * @return Возращает сложенный массив.
     */
    public int[] getUnitedArrayUniversal(int[] array1, int[] array2) {
        int[] unitedArray = new int[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {
            unitedArray[i] = array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            unitedArray[unitedArray.length - array2.length + i] = array2[i];
        }
        return unitedArray;
    }

    /**
     * @param array
     * @return возвращает массив без дубликатов.
     */
    public int[] noDuplicate(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length;) {
                if (array[i] == (array[j])) {
                    int temp = array[array.length - 1];
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

    /**
     * Сортировка массива по возрастанию
     *
     * @param array Массив на вход.
     * @return Готовый, отсортированный массив.
     */
    public int[] bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }
}




