package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImpossibleMoveException;

/**
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class RookWhite extends Figure {

    public RookWhite(final Cell position) {
        super(position);
    }

    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps = new Cell[0];
        if (source.x == dest.x) {
            if (dest.y != source.y) {
                if (dest.y > source.y) {
                    steps = new Cell[dest.y - source.y];
                    for (int y = source.y + 1, i = 0; y <= dest.y; y++, i++) {
                        steps[i] = Cell.getCellByXAndY(source.x, y);
                    }
                } else {
                    steps = new Cell[source.y - dest.y];
                    for (int y = source.y - 1, i = 0; y >= dest.y; y--, i++) {
                        steps[i] = Cell.getCellByXAndY(source.x, y);
                    }
                }
            }
        }
        if (source.y == dest.y) {
            if (dest.x != source.x) {
                if (dest.x > source.x) {
                    steps = new Cell[dest.x - source.x];
                    for (int x = source.x + 1, i = 0; x <= dest.x; x++, i++) {
                        steps[i] = Cell.getCellByXAndY(x, source.y);
                    }
                } else {
                    steps = new Cell[source.x - dest.x];
                    for (int x = source.x - 1, i = 0; x >= dest.x; x--, i++) {
                        steps[i] = Cell.getCellByXAndY(x, source.y);
                    }
                }
            }
        }
        if (steps.length == 0) {
            throw new ImpossibleMoveException();
        } else {
            return steps;
        }
    }

    public Figure copy(Cell dest) {
        return new RookWhite(dest);
    }
}
