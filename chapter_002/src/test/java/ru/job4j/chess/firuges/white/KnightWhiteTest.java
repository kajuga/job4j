package ru.job4j.chess.firuges.white;

//import jdk.nashorn.internal.runtime.regexp.joni.constants.CCSTATE;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImpossibleMoveException;

import static org.junit.Assert.*;

/**
 * Тест перемещений объекта "белый коник"
 */

public class KnightWhiteTest {

    /*
    вперед на 2 клетки - вправо "Г" (белые снизу)
     */
    @Test
    public void whenKnightUpRightMovie() throws ImpossibleMoveException {
        KnightWhite knightWhite = new KnightWhite(Cell.B1);
        Cell[] expected = new Cell[]{Cell.C3};
        Cell[] actual = knightWhite.way(Cell.B1, Cell.C3);
        Assert.assertArrayEquals(expected, actual);
    }

    /*
    вперед на 2 клетки - влево
     */
    @Test
    public void whenKnightUpLeftMoving() throws ImpossibleMoveException {
        KnightWhite knightWhite = new KnightWhite(Cell.B1);
        Cell[] expected = new Cell[]{Cell.A3};
        Cell[] actual = knightWhite.way(Cell.B1, Cell.A3);
        Assert.assertArrayEquals(expected, actual);
    }

    /*
    влево на 2, вперед на 1 (перевернутая "Г")S
     */
    @Test
    public void whenKnightLeftUpMoving() throws ImpossibleMoveException {
        KnightWhite knightWhite = new KnightWhite(Cell.C1);
        Cell[] expected = new Cell[]{Cell.A2};
        Cell[] actual = knightWhite.way(Cell.C1, Cell.A2);
        Assert.assertArrayEquals(expected, actual);
    }

    /*
    вправо на 2, вперед(вверх) на 1
    */
    @Test
    public void whenKnightRightUpMoving() throws ImpossibleMoveException {
        KnightWhite knightWhite = new KnightWhite(Cell.B1);
        Cell[] expected = new Cell[]{Cell.D2};
        Cell[] actual = knightWhite.way(Cell.B1, Cell.D2);
        Assert.assertArrayEquals(expected, actual);
    }

    /*
    вниз/назад на 2 и влево на 1
     */
    @Test
    public void whenKnightBackLeftMoving() throws ImpossibleMoveException {
        KnightWhite knightWhite = new KnightWhite(Cell.B3);
        Cell[] expected = new Cell[]{Cell.A1};
        Cell[] actual = knightWhite.way(Cell.B3, Cell.A1);
        Assert.assertArrayEquals(expected, actual);
    }

    /*
    вниз/назад на 2 и вправо на 1
     */
    @Test
    public void whenKnightBackRightMoving() throws ImpossibleMoveException {
        KnightWhite knightWhite = new KnightWhite(Cell.D5);
        Cell[] expected = new Cell[]{Cell.E3};
        Cell[] actual = knightWhite.way(Cell.D5, Cell.E3);
        Assert.assertArrayEquals(expected, actual);
    }

    /*
    проверка работы метода copy
     */
    @Test
    public void testCopy() throws Exception {
        KnightWhite knightWhite = new KnightWhite(Cell.D4);
        Cell position = Cell.C1;
        Figure knightCopy = knightWhite.copy(position);
        Assert.assertTrue(knightWhite != knightCopy && knightCopy.position() == position);
    }

    /*
    тестирую появление ошибки ImpossibleMoveException
     */

    @Test(expected = ImpossibleMoveException.class)
    public void whenImpossibleMoveException() throws ImpossibleMoveException {
        KnightWhite knightWhite = new KnightWhite(Cell.B1);
        knightWhite.way(Cell.B1, Cell.D6);
    }
}


