package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * //Движение пешки - НЕ РЕАЛИЗОВАНО перемещение по диагонали при съедании противника
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PawnWhite implements Figure {
    private final Cell position;
    int firstStepPawnChecker = 0;

    public PawnWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
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
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnWhite(dest);
    }
}
