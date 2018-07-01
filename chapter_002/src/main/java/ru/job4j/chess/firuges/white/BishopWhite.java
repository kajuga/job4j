package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImpossibleMoveException;

/**
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BishopWhite extends Figure {

    public BishopWhite(final Cell position) {
        super(position);
    }

    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        Cell[] steps = new Cell[Math.abs(deltaX)];
        if (Math.abs(deltaX) != Math.abs(deltaY)) {
            throw new ImpossibleMoveException();
        } else {
            int index = 0;
            int stepX = deltaX > 0 ? 1 : -1;
            int stepY = deltaY > 0 ? 1 : -1;
            for (int x = deltaX > 0 ? source.x + 1 : source.x - 1,
                 y = deltaY > 0 ? source.y + 1 : source.y - 1;
                 (deltaX > 0 ? x <= dest.x : x >= dest.x) && (deltaY > 0 ? y <= dest.y : y >= dest.y);
                 x = x + stepX, y = y + stepY) {
                steps[index++] = Cell.getCellByXandY(x, y);
            }
        }
        return steps;
    }

    public BishopWhite copy(Cell dest) {
        return new BishopWhite(dest);
    }
}