package ru.job4j.array;

/**
 * Создание двухмерного массива
 *
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 * @version 0.1.
 */
public class Matrix {

    /**
     * @param size размер таблицы.
     * @return возвращает заполненную таблицу.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}
