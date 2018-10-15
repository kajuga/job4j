package ru.job4j.set;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class SimpleSetTest {

    @Test
    public void xxxxx() {
        SimpleSet<Integer> simpleSet = new SimpleSet <>();
        simpleSet.add(25);
        simpleSet.add(15);
        simpleSet.add(5);
        simpleSet.add(4425);
    }


    }



