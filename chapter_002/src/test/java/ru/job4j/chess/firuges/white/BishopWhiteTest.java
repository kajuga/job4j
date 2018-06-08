package ru.job4j.chess.firuges.white;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.*;

/**
 * Test white bishop`s moving
 *
 * @throws Exception
 */

public class BishopWhiteTest {

/*
Метод тестирует возникновение ошибки при невозможности переместить фигуру в заданный квадрат (передвигаю влево по горизонтали, клетка свободная).
 */
    @Test(expected = ImpossibleMoveException.class)
    public void whenImpossibleMove() throws ImpossibleMoveException {
        BishopWhite bishopWhite = new BishopWhite(Cell.C1);
        bishopWhite.way(Cell.C1, Cell.B1);
    }

/*
Тестирую возникновение ошибки при перемещении объекта на клетку,уже занятую другой фигурой.
*/

    @Test(expected = OccupiedWayException.class)
    public void whenOccupiedWay() throws OccupiedWayException, ImpossibleMoveException {
        BishopWhite bishopWhite = new BishopWhite(Cell.C1);
        PawnWhite pawnWhite = new PawnWhite(Cell.E3);
        bishopWhite.way(Cell.C1, Cell.E3);
    }

    /**
     * Тут ее тестов на другие ошибки (2) нужно напридумывать
     *
     * @throws ImpossibleMoveException
     */

/*
Тестируем движение белого слона вперед/вправо (нет препятствий, белые снизу)
*/
    @Test()
    public void bishopRightUpMovie() throws ImpossibleMoveException {
        BishopWhite bishopWhite = new BishopWhite(Cell.F5);
        Cell[] expected = new Cell[]{Cell.G2, Cell.H3};
        Cell[] actual = bishopWhite.way(Cell.F5, Cell.H3);
        Assert.assertArrayEquals(expected, actual);
    }
/*
Тестируем движение белого слона вперед/влево (нет препятствий, белые снизу)
*/

    @Test
    public void bishopLeftUpMovie() throws ImpossibleMoveException {
        BishopWhite bishopWhite = new BishopWhite(Cell.C1);
        Cell[] expected = new Cell[]{Cell.B2, Cell.A3};
        Cell[] actual = bishopWhite.way(Cell.C1, Cell.A3);
        Assert.assertArrayEquals(expected, actual);
    }

/*
Тестирую движение белого слоника вниз/влево (белые все еще снизу)
*/
    @Test
    public void bishopLeftDownMovie() throws ImpossibleMoveException {
        BishopWhite bishopWhite = new BishopWhite(Cell.H3);
        Cell[] expected = new Cell[]{Cell.G2, Cell.F1};
        Cell[] actual = bishopWhite.way(Cell.H3, Cell.F1);
        Assert.assertArrayEquals(expected, actual);
    }

/*
Tестирую движение белого слоника вниз/вправо (белые снизу)
*/
    @Test
    public void bishopLeftRightMovie() throws ImpossibleMoveException {
        BishopWhite bishopWhite = new BishopWhite(Cell.A3);
        Cell[] expected = new Cell[]{Cell.B2, Cell.C1};
        Cell[] actual = bishopWhite.way(Cell.A3, Cell.C1);
        Assert.assertArrayEquals(expected, actual);
    }

/*
Тестирую работу метода Copy, сравнивая первоначальную и "скопированную" в произвольную клетку фигуру слона.
*/
    @Test
    public void copy() throws Exception {
        BishopWhite bishopWhite = new BishopWhite(Cell.C1);
        Cell position = Cell.A5;
        BishopWhite copy = bishopWhite.copy(position);
        Assert.assertTrue(bishopWhite != copy
                && copy.position() == position);
    }

}