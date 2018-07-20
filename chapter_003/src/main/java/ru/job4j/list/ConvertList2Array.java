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

    /**
     *
     * В этом методе прохожу по всем элементам всех массивов в списке list и добавить их в один общий лист Integer.
     * @param list
     * @return
     */
    public List<Integer> convert(List<int[]> list) {
        List list1 = new ArrayList<>();
        for (int[] i: list) {
            for (int j : i) {
                list1.add(j);
            }
        }
        return list1;
    }
}

