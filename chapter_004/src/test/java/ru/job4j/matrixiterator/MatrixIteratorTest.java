package ru.job4j.matrixiterator;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MatrixIteratorTest {

    @Test
    public void whenGetNextCallShouldPointerForward(){

        MatrixIterator mat = new MatrixIterator(new int[] {1, 3});

        mat.next();
        int result = mat.next();

        assertThat(result, is(3));
    }

    @Test
    public void whenCheckNextPositionShouldReturnConstantValue(){
    MatrixIterator mat = new MatrixIterator(new int[] {1});
    mat.next();
    mat.hasNext();
    boolean result = mat.hasNext();
    assertThat(result, is(false));
    }
}