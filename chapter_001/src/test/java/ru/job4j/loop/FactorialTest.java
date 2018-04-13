package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FactorialTest {

    @Test
    public void whenCountIsFiveFactorialIs120() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(5);
        int expected = 120;
        assertThat(result, is(expected));
    }

    @Test
    public void whenCountIsOneFactorialIsOne() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(1);
        int expected = 1;
        assertThat(result, is(expected));
    }
}