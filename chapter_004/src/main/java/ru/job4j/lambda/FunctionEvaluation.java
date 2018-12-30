package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
//import java.util.function.Function;

public class FunctionEvaluation {


    List <Integer> diapason(int start, int end, Function<Integer> func) {
        List <Integer> result = new ArrayList <>();
        for (int index = start; index != end; index++) {
            result.add(func.calc(index));
        }
        return result;
    }

    public static void main(String[] args) {
        FunctionEvaluation funcEva = new FunctionEvaluation();
        funcEva.diapason(5, 8, new Function <Integer>() {
            @Override
            public Integer calc(Integer x) {
                return 2 * x + 1;
            }
        });
    }
}




/*
List<Double> diapason(int start, int end, Function<Double, Double> func);
Линейной называется функция вида y=kx+by=kx+b, где kk и bb ­– любые числа (они называются коэффициентами).
Другими словами, линейная функция – это такая зависимость, что функция прямо пропорциональна аргументу.

 */
