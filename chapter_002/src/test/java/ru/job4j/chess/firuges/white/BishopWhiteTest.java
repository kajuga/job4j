package ru.job4j.chess.firuges.white;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.*;

/**
 * Тестирую белого слоника
 */

public class BishopWhiteTest {

    /*
    Test incorrect movie - catch ImpossibleMoveException
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenImpossibleMoveException() throws ImpossibleMoveException {
        BishopWhite bishopWhite = new BishopWhite(Cell.C1);
        bishopWhite.way(Cell.C1, Cell.B1);
    }

    /*
    Up - Right белые снизу)
    */
    @Test()
    public void bishopRightUpMovie() throws ImpossibleMoveException {
        BishopWhite bishopWhite = new BishopWhite(Cell.C2);
        Cell[] expected = new Cell[]{Cell.D3, Cell.E4};
        Cell[] actual = bishopWhite.way(Cell.C2, Cell.E4);
        Assert.assertArrayEquals(expected, actual);
    }

    /*
    Up - Left (белые снизу)
    */
    @Test
    public void bishopUpLeftMovie() throws ImpossibleMoveException {
        BishopWhite bishopWhite = new BishopWhite(Cell.C1);
        Cell[] expected = new Cell[]{Cell.B2, Cell.A3};
        Cell[] actual = bishopWhite.way(Cell.C1, Cell.A3);
        Assert.assertArrayEquals(expected, actual);
    }

    /*
    Back - Left(белые снизу)
    */
    @Test
    public void bishopBackLeftMovie() throws ImpossibleMoveException {
        BishopWhite bishopWhite = new BishopWhite(Cell.H3);
        Cell[] expected = new Cell[]{Cell.G2, Cell.F1};
        Cell[] actual = bishopWhite.way(Cell.H3, Cell.F1);
        Assert.assertArrayEquals(expected, actual);
    }

    /*
    Back - Right
    */
    @Test
    public void bishopBackRightMovie() throws ImpossibleMoveException {
        BishopWhite bishopWhite = new BishopWhite(Cell.A3);
        Cell[] expected = new Cell[]{Cell.B2, Cell.C1};
        Cell[] actual = bishopWhite.way(Cell.A3, Cell.C1);
        Assert.assertArrayEquals(expected, actual);
    }

    /*
    Test copy
    */
    @Test
    public void testCopy() throws Exception {
        BishopWhite bishopWhite = new BishopWhite(Cell.C1);
        Cell position = Cell.A5;
        BishopWhite copy = bishopWhite.copy(position);
        Assert.assertTrue(bishopWhite != copy
                && copy.position() == position);
    }
}






