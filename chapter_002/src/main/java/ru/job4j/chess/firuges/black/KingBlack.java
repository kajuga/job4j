package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class KingBlack implements Figure {
    private final Cell position;

    public KingBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (dest.x == source.x + 1 && dest.y == source.y - 1){
            steps = new Cell[]{dest};
        }
        else if (dest.x == source.x + 1 && dest.y == source.y){
            steps = new Cell[]{dest};
        }
        else if (dest.x == source.x && dest.y == source.y - 1) {
            steps = new Cell[]{dest};
        }
        else if (dest.x == source.x - 1 && dest.y == source.y - 1) {
            steps = new Cell[]{dest};
        }
        else if (dest.x == source.x - 1 && dest.y == source.y) {
            steps = new Cell[]{dest};
        }
        else if (dest.x == source.x - 1 && dest.y == source.y + 1) {
            steps = new Cell[]{dest};
        }
        else if (dest.x == source.x && dest.y == source.y + 1) {
            steps = new Cell[]{dest};
        }
        else if (dest.x == source.x + 1 && dest.y == source.y + 1) {
            steps = new Cell[]{dest};
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KingBlack(dest);
    }
}
