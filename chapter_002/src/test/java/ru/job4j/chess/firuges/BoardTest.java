package ru.job4j.chess.firuges;

import javafx.scene.Group;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.chess.firuges.black.*;
import ru.job4j.chess.firuges.white.*;

import static org.junit.Assert.*;

/**
 * Тест методов класса Board
 */
public class BoardTest {

    private Board board;

    /*
    Заполняем доску полностью 32 фигурами
     */
    @Before
    public void init() {
        board = new Board();
        board.add(new PawnBlack(Cell.A7));
        board.add(new PawnBlack(Cell.B7));
        board.add(new PawnBlack(Cell.C7));
        board.add(new PawnBlack(Cell.D7));
        board.add(new PawnBlack(Cell.E7));
        board.add(new PawnBlack(Cell.F7));
        board.add(new PawnBlack(Cell.G7));
        board.add(new PawnBlack(Cell.H7));
        board.add(new RookBlack(Cell.A8));
        board.add(new KnightBlack(Cell.B8));
        board.add(new BishopBlack(Cell.C8));
        board.add(new QeenBlack(Cell.D8));
        board.add(new KingBlack(Cell.E8));
        board.add(new BishopBlack(Cell.F8));
        board.add(new KnightBlack(Cell.G8));
        board.add(new RookBlack(Cell.H8));
        board.add(new PawnWhite(Cell.A2));
        board.add(new PawnWhite(Cell.B2));
        board.add(new PawnWhite(Cell.C2));
        board.add(new PawnWhite(Cell.D2));
        board.add(new PawnWhite(Cell.E2));
        board.add(new PawnWhite(Cell.F2));
        board.add(new PawnWhite(Cell.G2));
        board.add(new PawnWhite(Cell.H2));
        board.add(new RookWhite(Cell.A1));
        board.add(new KnightWhite(Cell.B1));
        board.add(new BishopWhite(Cell.C1));
        board.add(new QeenWhite(Cell.D1));
        board.add(new KingWhite(Cell.E1));
        board.add(new BishopWhite(Cell.F1));
        board.add(new KnightWhite(Cell.G1));
        board.add(new RookWhite(Cell.H1));
    }

    @Test
    public void testMove() throws Exception {
        boolean expected = true;
        board.move(Cell.A2, Cell.A3);
        boolean actual = board.move(Cell.A3, Cell.A4);
        Assert.assertTrue(expected == actual);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testMoveImpossib() throws Exception {
        board.move(Cell.A2, Cell.A4);
        board.move(Cell.A4, Cell.A3);
    }

    @Test(expected = OccupiedWayException.class)
    public void testMoveOccupied() throws Exception {
        board.move(Cell.A1, Cell.A2);
    }

    @Test(expected = FigureNotFoundException.class)
    public void testFigureNotFound() throws Exception {
        board.move(Cell.A3, Cell.A4);
    }
}