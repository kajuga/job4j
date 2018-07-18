package ru.job4j.departments;

import java.util.*;

public class Departments {
    public static void main(String[] args) {

        String[] income= {"K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        List<String> list = Arrays.asList(income);

        System.out.println("");
        System.out.println("До сортировки: ");
        for (String dep: list) {
            System.out.println(dep);
        }

        System.out.println("");
        Departments dep  = new Departments();
        String[] testFoundDepos;
        testFoundDepos = dep.findDepos(income);
        System.out.println("Массив найденных департаментов: ");

        for (String dps: testFoundDepos) {
            System.out.println(dps);
        }
    }


    /**
     * Назначение: для того чтобы получить название департамента (оно есть в любой передаваемой строке, разделенной "\")
     * беру массив строк
     */
    public String[] findDepos (String[] arr){
        Set<String> pullOutNameDepts = new TreeSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].contains("\\")){
                String[]temp = arr[i].split("\\\\");
                pullOutNameDepts.add(temp[0]);
            }
            pullOutNameDepts.add(arr[i]);
        }
        return pullOutNameDepts.toArray(new String[pullOutNameDepts.size()]);
    }



}

/*
        "K1\SK1"
        "K1\SK2"
        "K1\SK1\SSK1"
        "K1\SK1\SSK2"
        "K2"
        "K2\SK1\SSK1"
        "K2\SK1\SSK2"
        */