package ru.job4j.generics;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {
    private Iterator<Integer> it;
    private Iterator<Integer> it2;

    @Before
    public void setUp() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>();
        simpleArray.add(2);
        simpleArray.add(4);
        simpleArray.add(6);
        it = simpleArray.iterator();
        it2 = simpleArray.iterator();
    }

    @Test
    public void testThatCallTwoIteratorsDoNotMakeProblems() {
        it.next();
        int res1 = it.next();
        it2.next();
        it2.next();
        int res2 = it2.next();
        Assert.assertTrue(res1 == 4 && res2 == 6);
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.next(), Matchers.is(2));
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.next(), Matchers.is(4));
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.next(), Matchers.is(6));
    }

    @Test
    public void testsThatNextMethodOfBothIteratorsDoesntDependsOneOfOther() {
        assertThat(it.next(), Matchers.is(2));
        assertThat(it2.next(), Matchers.is(2));
        assertThat(it.next(), Matchers.is(4));
        assertThat(it.next(), Matchers.is(6));
        assertThat(it2.next(), Matchers.is(4));
        assertThat(it2.next(), Matchers.is(6));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(6));
    }
}