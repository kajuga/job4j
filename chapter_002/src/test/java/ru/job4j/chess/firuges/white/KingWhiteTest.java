package ru.job4j.chess.firuges.white;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImpossibleMoveException;

import static org.junit.Assert.*;

/**
White King Test moving
 */

public class KingWhiteTest {

    /*
    Up - Right
    */
    @Test()
    public void kingRightUpMovie() throws ImpossibleMoveException {
        KingWhite kingWhite = new KingWhite(Cell.D1);
        Cell[] expected = new Cell[]{Cell.D2};
        Cell[] actual = kingWhite.way(Cell.D1, Cell.D2);
        Assert.assertArrayEquals(expected, actual);
    }

    /*
    Up - Left
    */
    @Test
    public void kingUpLeftMovie() throws ImpossibleMoveException {
        KingWhite kingWhite = new KingWhite(Cell.D1);
        Cell[] expected = new Cell[]{Cell.C2};
        Cell[] actual = kingWhite.way(Cell.D1, Cell.C2);
        Assert.assertArrayEquals(expected, actual);
    }

    /*
    Back-Left
    */
    @Test
    public void kingBackLeftMovie() throws ImpossibleMoveException {
        KingWhite kingWhite = new KingWhite(Cell.D2);
        Cell[] expected = new Cell[]{Cell.C1};
        Cell[] actual = kingWhite.way(Cell.D2, Cell.C1);
        Assert.assertArrayEquals(expected, actual);
    }

    /*
    Back-Right
    */
    @Test
    public void kingLeftRightMovie() throws ImpossibleMoveException {
        KingWhite kingWhite = new KingWhite(Cell.D2);
        Cell[] expected = new Cell[]{Cell.E1};
        Cell[] actual = kingWhite.way(Cell.D2, Cell.E1);
        Assert.assertArrayEquals(expected, actual);
    }
    /*
    Up
     */
    @Test()
    public void kingUpMovie() throws ImpossibleMoveException {
        KingWhite kingWhite = new KingWhite(Cell.C2);
        Cell[] expected = new Cell[]{Cell.C3};
        Cell[] actual = kingWhite.way(Cell.C2, Cell.C3);
        Assert.assertArrayEquals(expected, actual);
    }

    /*
    Back
       */
    @Test()
    public void kingBackMovie() throws ImpossibleMoveException {
        KingWhite kingWhite = new KingWhite(Cell.C4);
        Cell[] expected = new Cell[]{Cell.C5};
        Cell[] actual = kingWhite.way(Cell.C4, Cell.C5);
        Assert.assertArrayEquals(expected, actual);
    }

    /*
    Left
    */
    @Test()
    public void kingLeftMovie() throws ImpossibleMoveException {
        KingWhite kingWhite = new KingWhite(Cell.C4);
        Cell[] expected = new Cell[]{Cell.C3};
        Cell[] actual = kingWhite.way(Cell.C4, Cell.C3);
        Assert.assertArrayEquals(expected, actual);
    }

    /*
    Right
    */
    @Test()
    public void kingRightMovie() throws ImpossibleMoveException {
        KingWhite kingWhite = new KingWhite(Cell.A5);
        Cell[] expected = new Cell[]{Cell.B5};
        Cell[] actual = kingWhite.way(Cell.A5, Cell.B5);
        Assert.assertArrayEquals(expected, actual);
    }
    
    /*
    Test Copy
    */
    @Test
    public void testCopy() throws Exception {
        KingWhite kingWhite = new KingWhite(Cell.D1);
        Cell position = Cell.A5;
        Figure copy = kingWhite.copy(position);
        Assert.assertTrue(kingWhite != copy
                && copy.position() == position);
    }

    /*
    Test ImpossibleMoveException
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenImpossibleMoveException() throws ImpossibleMoveException {
        KingWhite kingWhite = new KingWhite(Cell.D1);
        kingWhite.way(Cell.D1, Cell.B5);
    }
}