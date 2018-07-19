package ru.job4j.departments;

import java.util.*;

public class Departments {

    public static void main(String[] args) {

        String[] income= {"K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1","K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        List<String> list = Arrays.asList(income);

        System.out.println("");
        System.out.println("До сортировки: ");
        for (String dep: list) {
            System.out.println(dep);
        }

        System.out.println("");
        Departments dep  = new Departments();
        String[] testFoundDepos;
        testFoundDepos = dep.sortDeposAsc(income);
        System.out.println("Массив найденных департаментов по возрастанию: ");
        for (String dps: testFoundDepos) {
            System.out.println(dps);
        }

        testFoundDepos = dep.sortDeposDesc(income);
        System.out.println("Массив найденных департаментов по убыванию: ");
        for (String dps: testFoundDepos) {
            System.out.println(dps);
        }
    }


    /**
     * Получение отсортированного по возрастанию массива вх. массив -> treeSet -> итоговый массив.
     */
    public String[] sortDeposAsc(String[] arr){
        Set<String> pullOutNameDepts = new TreeSet<>();
        for (int i = 0; i < arr.length; i++) {
            String[] temp = arr[i].split("\\\\");
            if (temp.length > 0) {
                pullOutNameDepts.add(temp[0]);
            }
            if (temp.length > 1) {
                pullOutNameDepts.add(temp[0] + "\\" +temp[1]);
            }
            pullOutNameDepts.add(arr[i]);
        }

        return pullOutNameDepts.toArray(new String[pullOutNameDepts.size()]);
    }

    /**
     * Получение отсортированного массива по убыванию.
     */
    public String[] sortDeposDesc(String[] arr){
        String[] pullOutNameDepts = sortDeposAsc(arr);

        Comparator<String> comparatorDesc = new Comparator <String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] tempS1 = s1.split("\\\\");
                String[] tempS2 = s2.split("\\\\");

                int res = 0;
                if (tempS2.length > 0 && tempS1.length > 0){
                    res = tempS2[0].compareTo(tempS1[0]);
                    if (res == 0){
                        try {
                            res = tempS2[1].compareTo(tempS1[1]);
                            if (res == 0){
                                res = tempS2[2].compareTo(tempS1[2]);
                            }
                        }catch (ArrayIndexOutOfBoundsException e){

                        }
                    }
                }
                return res;
            }
        };
        Arrays.sort(pullOutNameDepts, comparatorDesc);
        return pullOutNameDepts;
    }
}