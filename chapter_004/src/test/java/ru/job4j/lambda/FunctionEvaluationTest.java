package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FunctionEvaluationTest {

//реализовал лист на Integerах, чтоб суть уяснить
    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionEvaluation function = new FunctionEvaluation();
        List <Integer> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Integer> expected = Arrays.asList(11, 13, 15);
        assertThat(result, is(expected));
    }

//todo
//    @Test
//    public void whenLinearFunctionThenLinearResults() {
//        FunctionEvaluation function = new FunctionEvaluation();
//        List <Double> result = function.diapason(5, 8, x -> 2 * x + 1);
//        List<Double> expected = Arrays.asList(11D, 13D, 15D);
//        assertThat(result, is(expected));
//    }




}