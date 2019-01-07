package ru.job4j.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Конвертация двухмерного массива в Arraylist
 * @author Fedorov Aleksander (msg2fedorov@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class ConvertMatrix2List {
    /**
     * Метод конвертирует двумерный массив в ArrayList
     * @param array входной двумерный массив с данными.
     * @return ArrayList.
     */
    public List<Integer> toList(int[][] array) {
        return Arrays.stream(array)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
    }

        public List<Integer> toListWithForEach(int[][] array) {
            List list = new ArrayList<>();
            for (int[] i : array) {
                for (int j : i) {
                    list.add(j);
                }
            }
            return list;
    }
}