package ru.job4j.array;


/**
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 * Совокупление двух массивов произвольного размера в один.
 */
public class ArrayHomeTask {

    /**
     * Метод, объединяющий 2 переданных в него массива.
     *
     * @param array1 Передаваемый для суммирования массив №1;
     * @param array2 Передаваемый для суммирования массив №2;
     * @return Возращает сложенный массив.
     */
    public int[] getUnitedArray(int[] array1, int[] array2) {
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
     * Метод, объединяющий, сортирующий 2 переданных в него массива
     *
     * @param array1 Передаваемый для суммирования массив №1;
     * @param array2 Передаваемый для суммирования массив №2;
     * @return Возращает сложенный массив.
     */

    public int[] getUnitedArrayWithBubble(int[] array1, int[] array2) {
        int[] unitedArray = new int[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {
            unitedArray[i] = array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            unitedArray[unitedArray.length - array2.length + i] = array2[i];
        }
        for (int i = unitedArray.length - 1; i > 0; i--){
            for(int j = 0; j < i; j++) {
                if (unitedArray[j] > unitedArray[j + 1]) {
                    int tmp = unitedArray[j];
                    unitedArray[j] = unitedArray[j + 1];
                    unitedArray[j + 1] = tmp;
                }
            }
        }
        return unitedArray;
    }
}