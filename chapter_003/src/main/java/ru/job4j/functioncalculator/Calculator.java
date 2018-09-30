package ru.job4j.functioncalculator;

import java.util.List;
import java.util.function.Function;

public class Calculator {

    List<Double> diapason(int start, int end, Function<Double, Double> func) {

        return null;
    }



}
/**
Полух написал - взять решение за основу

 1. Реализовать метод подсчета функции в диапазоне.

 List<Double> diapason(int start, int end, Function<Double, Double> func);

 2. Реализации функций.
 - линейная.
 - квадратичная.
 - логарифмическая.

 (x) - > return 7*x+9;

 List<Double> diapason(int start, int end, Function<Double, Double> func){
 List<Double> result = new ArrayList;
 for(int x = start; x++; x <= end){
 result.add(func.apply(x));
 }
 return result;
 }




 3. Необходимо использовать только встроенные функциональные интерфейсы

 int x = 3;
 int y = 7;

 IntStream.range(x, y).reduce(1, (prevRes,current) -> prevRes*current);

*/