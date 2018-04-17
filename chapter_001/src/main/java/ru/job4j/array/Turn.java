package ru.job4j.array;

/**
 * Класс переворачивает массив задом наперед.
 *
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 */
public class Turn {

    /**
     * @param array массив, который нужно первернуть.
     * @return перевернутый массив.
     */
    public int[] back(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }
}
