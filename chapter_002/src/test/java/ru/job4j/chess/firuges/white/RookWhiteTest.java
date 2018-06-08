package ru.job4j.chess.firuges.white;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImpossibleMoveException;

import static org.junit.Assert.*;

/**
 * Тестирую белую турку (движения и ошибка)
 */

public class RookWhiteTest {

    /*
    Up
     */
    @Test()
    public void rookUpMovie() throws ImpossibleMoveException {
        RookWhite rookWhite = new RookWhite(Cell.C2);
        Cell[] expected = new Cell[]{Cell.C3, Cell.C4};
        Cell[] actual = rookWhite.way(Cell.C2, Cell.C4);
        Assert.assertArrayEquals(expected, actual);
    }

    /*
    Back
       */
    @Test()
    public void rookBackMovie() throws ImpossibleMoveException {
        RookWhite rookWhite = new RookWhite(Cell.C4);
        Cell[] expected = new Cell[]{Cell.C3, Cell.C2, Cell.C1};
        Cell[] actual = rookWhite.way(Cell.C4, Cell.C1);
        Assert.assertArrayEquals(expected, actual);
    }

    /*
    Left
    */
    @Test()
    public void rookLeftMovie() throws ImpossibleMoveException {
        RookWhite rookWhite = new RookWhite(Cell.E5);
        Cell[] expected = new Cell[]{Cell.D5, Cell.C5, Cell.B5, Cell.A5};
        Cell[] actual = rookWhite.way(Cell.E5, Cell.A5);
        Assert.assertArrayEquals(expected, actual);
    }

    /*
    Right
    */
    @Test()
    public void rookRightMovie() throws ImpossibleMoveException {
        RookWhite rookWhite = new RookWhite(Cell.A5);
        Cell[] expected = new Cell[]{Cell.B5, Cell.C5, Cell.D5};
        Cell[] actual = rookWhite.way(Cell.A5, Cell.D5);
        Assert.assertArrayEquals(expected, actual);
    }

    /*
    Exception test
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenImpossibleMoveException() throws ImpossibleMoveException {
        RookWhite rookWhite = new RookWhite(Cell.A5);
        rookWhite.way(Cell.A5, Cell.B1);
    }

    /*
    Copy test
    */
    @Test
    public void testCopy() throws Exception {
        RookWhite rookWhite = new RookWhite(Cell.A5);
        Cell position = Cell.H1;
        Figure copy = rookWhite.copy(position);
        Assert.assertTrue(rookWhite != copy
                && copy.position() == position);
    }
}