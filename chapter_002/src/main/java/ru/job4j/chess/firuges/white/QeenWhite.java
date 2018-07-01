package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImpossibleMoveException;

/**
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class QeenWhite extends Figure {

    public QeenWhite(final Cell position) {
        super(position);
    }

    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        Cell[] steps = new Cell[Math.abs(deltaX)];

            return steps;
        }

    public Figure copy(Cell dest) {
        return new QeenWhite(dest);
    }
}
