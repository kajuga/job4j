package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImpossibleMoveException;
import ru.job4j.chess.firuges.OccupiedWayException;

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

        if (Math.abs(deltaX) == Math.abs(deltaY)){
            Cell[] steps = new Cell[Math.abs(deltaX)];
            if (deltaX > 0 && deltaY > 0) {
                for (int i = 1; i <= deltaX; i++) {
                    steps[i - 1] = Cell.getCellByXAndY(source.x + i, source.y + i);
                }
            }else if (deltaX < 0 && deltaY < 0){
                //TODO
            } else if (deltaX < 0 && deltaY > 0){
                //TODO
            } else if (deltaX > 0 && deltaY < 0){
                //TODO
            }
            return steps;
        }
        throw new ImpossibleMoveException();
    }

    public BishopWhite copy(Cell dest) {
        return new BishopWhite(dest);
    }
}