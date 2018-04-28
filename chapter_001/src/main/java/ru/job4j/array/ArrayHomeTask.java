package ru.job4j.array;

import java.util.Arrays;

/**
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 * Совокупление двух массивов произвольного размера в один с последующей сортировкой и удалением повторяющихся значений.
 */
public class ArrayHomeTask {
//    public static void main(String[] args) {
//        int[] array1 = new int[]{1, 2, 2, 0, 4, 4, 12, 12, 10, 17, 0};
//        int[] array3 = new int[]{133, 0, 133, 12, 12, 10, 17, 18, 17, 10};
//        int[] arraySum = getUnitedArrayUniversal(array1, array3);
//        int[] arraySum2 = getUnitedWithImportedLibrary(array1, array3);
//        int[] arraySum3 = noDuplicate(arraySum2);
//        int[] arraySum4 = bubbleSort(arraySum3);
//        int[] arraySumFinish = bubbleSort(noDuplicate(getUnitedWithImportedLibrary(array1, array3)));
//
//        System.out.println("Совокупление массива №1 и №3 (вручную)");
//        for (int i = 0; i < arraySum.length; i++) {
//            System.out.print(arraySum[i] + " ");
//        }
//        System.out.println("");
//        System.out.println("Совокупление массива №1 и №3 при помощи импортированного класса ArrayUtils (альтернативный вариант)");
//        for (int i : arraySum2) {
//            System.out.print(i + " ");
//        }
//        System.out.println("");
//        System.out.println("Удаление дубликатов из получившегося совокупленного массива №1 и №3");
//        for (int i : arraySum3) {
//            System.out.print(i + " ");
//        }
//        System.out.println("");
//        System.out.println("Итоговая сортировка получившегося массива во возрастанию");
//        for (int i : arraySum4) {
//            System.out.print(i + " ");
//        }
//
//        System.out.println("");
//        System.out.println("Тестовый запуск - все в одном");
//        for (int i : arraySumFinish) {
//            System.out.print(i + " ");
//        }
//    }

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




