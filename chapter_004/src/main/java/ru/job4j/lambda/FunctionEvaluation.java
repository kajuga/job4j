package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 * Lambda simple realisation example
 */

public class FunctionEvaluation {
    List <Double> diapason(int start, int end, UnaryOperator <Double> unar) {
        List <Double> result = new ArrayList <>();
        for (int index = start; index != end; index++) {
            result.add(unar.apply((double) index));
        }
        return result;
    }
}
