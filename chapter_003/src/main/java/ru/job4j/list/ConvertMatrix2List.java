package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Конвертация двухмерного массива в Arraylist
 * @author Fedorov Aleksander (msg2fedorov@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class ConvertMatrix2List {
    public List <Integer> toList(int[][] array) {
        List <Integer> list = new ArrayList <>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                list.add(array[i][j]);
            }
        }
        return list;
    }

        public List <Integer> toListWithForEach(int[][] array) {
            List list = new ArrayList <>();
            for (int [] i : array) {
                for(int j : i){
                    list.add(j);
                }
            }
            return list;
    }
}