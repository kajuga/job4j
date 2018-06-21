package ru.job4j.cofeemaker;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class CofeeMakerTest {

    /**
     * Тест кофемашина
     * @throws Exception
     */
    @Test
    public void changes() throws Exception {
        CofeeMaker cofeeMaker = new CofeeMaker();
        int[] result = cofeeMaker.changes(150, 101);
        int[] expect = new int[]{10, 10, 10, 10, 5, 2, 2};
        Assert.assertThat(result, Is.is(expect));
    }
}