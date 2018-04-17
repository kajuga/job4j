package ru.job4j.array;

/**
 * Сортировка пузырьком
 *
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 */
public class BubbleSort {

    /**
     *
     * @param array - сортируемый массив;
     * @return - отсортированный массив.
     */
    public int[] sort(int[] array) {
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

