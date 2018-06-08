package ru.job4j.chess.firuges.white;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.ImpossibleMoveException;

import static org.junit.Assert.*;

/**
 * Тестирую белую пешку (движения и ошибка)
 */

public class PawnWhiteTest {

    /*
    Вперед на 2 клетки (первый ход)
    */
    @Test
    public void pawnUpTwoCellFirstMovie() throws ImpossibleMoveException {
        PawnWhite pawnWhite = new PawnWhite(Cell.B2);
        Cell[] expected = new Cell[]{Cell.B3, Cell.B4};
        Cell[] actual = pawnWhite.way(Cell.B2, Cell.B4);
        Assert.assertArrayEquals(expected, actual);
    }

    /*
    Up
    */
    @Test
    public void pawnUpOneCellMovie() throws ImpossibleMoveException {
        PawnWhite pawnWhite = new PawnWhite(Cell.C2);
        Cell[] expected = new Cell[]{Cell.C3};
        Cell[] actual = pawnWhite.way(Cell.C2, Cell.C3);
        Assert.assertArrayEquals(expected, actual);
    }

    /*
    Testing wrong movie ImpossibleMoveException
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenPawnIncorrectMoving() throws ImpossibleMoveException {
        PawnWhite pawnWhite = new PawnWhite(Cell.C2);
        pawnWhite.way(Cell.C2, Cell.C5);
    }

    /*
    Test copy
     */
    @Test
    public void testCopy() {
        PawnWhite pawnWhite = new PawnWhite(Cell.B2);
        Cell position = Cell.H1;
        PawnWhite pawnCopy = pawnWhite.copy(position);
        Assert.assertTrue(pawnWhite != pawnCopy && pawnCopy.position() == position);
    }
}