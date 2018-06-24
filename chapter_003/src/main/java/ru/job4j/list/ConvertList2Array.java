package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

    public class ConvertList2Array {

        public static void main(String[] args) {
            List<Integer> list = new ArrayList <>(7);
            for (int i = 1; i <=7 ; i++) {
                list.add(i);
            }

            for (Integer lst : list) {
                System.out.print(lst + " ");
            }
            System.out.println(" " );
            System.out.println("================================");
            System.out.println("==== Пропускаю через метод =====");
            System.out.println("================================");

            ConvertList2Array convertList2Array = new ConvertList2Array();
            convertList2Array.toArray(list, 3);



        }



        public int[][] toArray(List <Integer> list, int rows) {
            int cells;
            if (list.size() % rows == 0) {
                cells = list.size() / rows;
            } else {
                cells = (list.size() / rows) + 1;
            }
            int[][] array = new int[rows][cells];
            int flagCells = 0;
            int flagRows = 0;
            for (Integer set : list) {
                array[flagRows][flagCells++] = set;
                if (flagCells == cells){
                    flagCells = 0;
                    flagRows++;
                }
            }
            return array;

        }


    }

