package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList2Array {

    public int[][] toArray(List<Integer> list, int rows) {
        int cells;
        if (list.size() % rows == 0) {
            cells = list.size() / rows;
        } else {
            cells = (int) (Math.ceil((double) list.size() / rows));
        }
        int[][] array = new int[rows][cells];
        int flagRow = 0;
        int flagCell = 0;
        for (Integer set : list) {
            array[flagRow][flagCell++] = set;
            if (flagCell == cells) {
                flagCell = 0;
                flagRow++;
            }
        }
        return array;

    }


}

