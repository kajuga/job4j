package ru.job4j.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ConvertMatrix2List {

    public List <Integer> toList(int[][] array) {
        List <Integer> list = new ArrayList <>();

        int flagRow = 0;
        int flagCell = 0;

        for (Integer set : list) {
            set = array[flagRow][flagCell++];
            if (flagCell == 888) {   //вот тут придумать как стоппер присобачить.
                                     // мб. попробовать переконвертить массив в одномерку, а потом залить в список? хз. как вариант.
                flagCell = 0;
                flagRow++;
            }
        }
        return list;
    }
}

