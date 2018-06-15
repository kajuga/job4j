package ru.job4j.array;


/**
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 * Совокупление двух массивов произвольного размера в один.
 */
public class ArrayHomeTask {
    //static int[] one = new int[]{0, 2, 1, 3};
    //static int[] two = new int[]{1, 0, 3, 4, 0};
    static int[] one = new int[]{1, 2, 3, 5};
    static int[] two = new int[]{1, 4, 5, 6};

//    public static void main(String[] args) {
//        ArrayHomeTask arrayHomeTask = new ArrayHomeTask();
//        int[] united = arrayHomeTask.getUniTedArrayNoBubble(one, two);
//        for (int i : united) {
//            System.out.println(i);
//
//        }
//    }

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
     * интересная безпузырьковая реализация
     */

    public int[] getUniTedArrayNoBubble(int[] one, int[] two) {
        int[] three = new int[one.length + two.length];
        int i = 0, j = 0, index = 0;
        while (i < one.length && j < two.length) {
            three[index++] = one[i] < two[j] ? one[i++] : two[j++];
            if (i < one.length) {
                System.arraycopy(one, i, three, index, (one.length - i));
            }
            if (j < two.length) {
                System.arraycopy(two, j, three, index, (two.length - j));
            }
        }
        return three;
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
        for (int i = unitedArray.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
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