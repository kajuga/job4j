package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImpossibleMoveException;

/**
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class KingWhite extends Figure {

    public KingWhite(final Cell position) {
        super(position);
    }

    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps = new Cell[0];
        if (dest.x == source.x + 1 && dest.y == source.y + 1) {
            steps = new Cell[]{Cell.getCellByXandY(dest.x, dest.y)};
        }
        if (dest.x == source.x - 1 && dest.y == source.y - 1) {
            steps = new Cell[]{Cell.getCellByXandY(dest.x, dest.y)};
        }
        if (dest.x == source.x + 1 && dest.y == source.y - 1) {
            steps = new Cell[]{Cell.getCellByXandY(dest.x, dest.y)};
        }
        if (dest.x == source.x - 1 && dest.y == source.y + 1) {
            steps = new Cell[]{Cell.getCellByXandY(dest.x, dest.y)};
        }
        if (dest.x == source.x && dest.y == source.y + 1) {
            steps = new Cell[]{Cell.getCellByXandY(dest.x, dest.y)};
        }
        if (dest.x == source.x && dest.y == source.y - 1) {
            steps = new Cell[]{Cell.getCellByXandY(dest.x, dest.y)};
        }
        if (dest.y == source.y && dest.x == source.x + 1) {
            steps = new Cell[]{Cell.getCellByXandY(dest.x, dest.y)};
        }
        if (dest.y == source.y && dest.x == source.x - 1) {
            steps = new Cell[]{Cell.getCellByXandY(dest.x, dest.y)};
        }
        if (steps.length == 0) {
            throw new ImpossibleMoveException();
        } else {
            return steps;
        }
    }

    public Figure copy(Cell dest) {
        return new KingWhite(dest);
    }
}