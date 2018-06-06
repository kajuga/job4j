package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PawnBlack implements Figure {
    private final Cell position;
    int firstStepPawnChecker = 0;

    public PawnBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        //Первый ход
        if (source.y == 6) {
            if (source.x == dest.x) {
                if (dest.y <= source.y && dest.y >= source.y - 2) {
                    steps = new Cell[source.y - dest.y];
                    for (int y = source.y - 1, i = 0; y >= dest.y; y--, i++) {
                        steps[i] = Cell.getCellByXAndY(source.x, y);
                    }
                }
            }
        } else {    //последующие ходы
            if (source.x == dest.x) {
                if (dest.y <= source.y && dest.y >= source.y - 1) {
                    steps = new Cell[]{Cell.getCellByXAndY(dest.x, dest.y)};
                }
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnBlack(dest);
    }
}
