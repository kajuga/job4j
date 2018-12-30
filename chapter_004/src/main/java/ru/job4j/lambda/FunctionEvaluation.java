package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
//import java.util.function.Function;

public class FunctionEvaluation {


    List<Integer> diapason(int start, int end, UnaryOperator<Integer> unar) {
        List<Integer> result = new ArrayList<>();
        for (int index = start; index != end; index++) {
            result.add(unar.apply(index));
        }
        return result;
    }

    public static void main(String[] args) {
        FunctionEvaluation funcEva = new FunctionEvaluation();
        funcEva.diapason(5, 8, (x) -> 2 * x + 1);
    }
}




/*
List<Double> diapason(int start, int end, Function<Double, Double> func);
Линейной называется функция вида y=kx+by=kx+b, где kk и bb ­– любые числа (они называются коэффициентами).

Квадратичной функцией называется функция вида y=ax2+bx+c, где a,b,c - числа, причем a≠0

Функцию, заданную формулой  y=logax , называют логарифмической функцией с основанием  a .
(a>0,a≠1) .

 */
