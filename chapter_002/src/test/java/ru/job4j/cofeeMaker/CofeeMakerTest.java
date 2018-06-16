package ru.job4j.cofeeMaker;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CofeeMakerTest {

    /**
     * Тест кофемашина
     * @throws Exception
     */
    @Test
    public void changes() throws Exception {
        CofeeMaker cofeeMaker = new CofeeMaker();
        int [] result = cofeeMaker.changes(50, 35);
        int[] expect = new int[]{10, 5};
        Assert.assertThat(result, Is.is(expect));
    }
}