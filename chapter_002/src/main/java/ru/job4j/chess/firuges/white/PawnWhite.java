package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImpossibleMoveException;

/**
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class PawnWhite extends Figure {

    public PawnWhite(Cell position) {
        super(position);
    }

    /**
     * Метод должен работать так. dest - задает ячейку, куда следует пойти. Если фигура может туда пойти. то Вернуть массив ячеек. которые должна пройти фигура.
     * Если фигура туда пойти не может. выбросить исключение ImposibleMoveException
     */
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        //Первый ход пешки - на 1 или 2 клетки
        Cell[] steps = new Cell[0];

        if (source.y == 1 && source.x == dest.x) {
            if (dest.y >= source.y && dest.y == source.y + 1) {
                steps = new Cell[1];
                steps[0] = Cell.getCellByXAndY(dest.x, dest.y);
            }
            if (dest.y >= source.y && dest.y == source.y + 2) {
                steps = new Cell[dest.y - source.y];
                for (int y = source.y + 1, i = 0; y <= dest.y; y++, i++) {
                    steps[i] = Cell.getCellByXAndY(source.x, y);
                }
            }
        }
        //Второй и последующие ходы
        if (source.y > 1 && source.x == dest.x) {
            if (dest.y >= source.y && dest.y == source.y + 1) {
                steps = new Cell[1];
                steps[0] = Cell.getCellByXAndY(dest.x, dest.y);
            }
        }
        if (steps.length == 0) {
            throw new ImpossibleMoveException();
        } else {
            return steps;
        }
    }

    /**
     * он должен создавать объект Figure с координатой Cell dest.
     * Например. для класса
     * class Bishop impl Figure {
     * Figure copy(Cell dest) {
     * return new Bishop(dest);
     * }
     * }
     */
    public PawnWhite copy(Cell dest) {
        return new PawnWhite(dest);
    }
}
