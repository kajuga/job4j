package ru.job4j.chess.firuges.white;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImpossibleMoveException;

/**
 White Qeen Test moving
 */

public class QeenWhiteTest {

    /*
    Up - Right
    */
    @Test()
    public void qeenRightUpMovie() throws ImpossibleMoveException {
        QeenWhite qeenWhite = new QeenWhite(Cell.D1);
        Cell[] expected = new Cell[]{Cell.D2};
        Cell[] actual = qeenWhite.way(Cell.D1, Cell.D2);
        Assert.assertArrayEquals(expected, actual);
    }

    /*
    Up - Left
    */
    @Test
    public void qeenUpLeftMovie() throws ImpossibleMoveException {
        QeenWhite qeenWhite = new QeenWhite(Cell.D1);
        Cell[] expected = new Cell[]{Cell.C2};
        Cell[] actual = qeenWhite.way(Cell.D1, Cell.C2);
        Assert.assertArrayEquals(expected, actual);
    }

    /*
    Back-Left
    */
    @Test
    public void qeenBackLeftMovie() throws ImpossibleMoveException {
        QeenWhite qeenWhite = new QeenWhite(Cell.D2);
        Cell[] expected = new Cell[]{Cell.C1};
        Cell[] actual = qeenWhite.way(Cell.D2, Cell.C1);
        Assert.assertArrayEquals(expected, actual);
    }

    /*
    Back-Right
    */
    @Test
    public void qeenLeftRightMovie() throws ImpossibleMoveException {
        QeenWhite qeenWhite = new QeenWhite(Cell.D2);
        Cell[] expected = new Cell[]{Cell.E1};
        Cell[] actual = qeenWhite.way(Cell.D2, Cell.E1);
        Assert.assertArrayEquals(expected, actual);
    }
    /*
    Up
     */
    @Test()
    public void qeenUpMovie() throws ImpossibleMoveException {
        QeenWhite qeenWhite = new QeenWhite(Cell.C2);
        Cell[] expected = new Cell[]{Cell.C3, Cell.C4};
        Cell[] actual = qeenWhite.way(Cell.C2, Cell.C4);
        Assert.assertArrayEquals(expected, actual);
    }

    /*
    Back
       */
    @Test()
    public void qeenBackMovie() throws ImpossibleMoveException {
        QeenWhite qeenWhite = new QeenWhite(Cell.C4);
        Cell[] expected = new Cell[]{Cell.C5};
        Cell[] actual = qeenWhite.way(Cell.C4, Cell.C5);
        Assert.assertArrayEquals(expected, actual);
    }

    /*
    Left
    */
    @Test()
    public void qeenLeftMovie() throws ImpossibleMoveException {
        QeenWhite qeenWhite = new QeenWhite(Cell.C4);
        Cell[] expected = new Cell[]{Cell.C3};
        Cell[] actual = qeenWhite.way(Cell.C4, Cell.C3);
        Assert.assertArrayEquals(expected, actual);
    }

    /*
    Right
    */
    @Test()
    public void qeenRightMovie() throws ImpossibleMoveException {
        QeenWhite qeenWhite = new QeenWhite(Cell.A5);
        Cell[] expected = new Cell[]{Cell.B5};
        Cell[] actual = qeenWhite.way(Cell.A5, Cell.B5);
        Assert.assertArrayEquals(expected, actual);
    }

    /*
    Test Copy
    */
    @Test
    public void testCopy() throws Exception {
        QeenWhite qeenWhite = new QeenWhite(Cell.D1);
        Cell position = Cell.A5;
        Figure copy = qeenWhite.copy(position);
        Assert.assertTrue(qeenWhite != copy
                && copy.position() == position);
    }

    /*
    Test ImpossibleMoveException
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenImpossibleMoveException() throws ImpossibleMoveException {
        QeenWhite qeenWhite = new QeenWhite(Cell.D1);
        qeenWhite.way(Cell.D1, Cell.B5);
    }
}