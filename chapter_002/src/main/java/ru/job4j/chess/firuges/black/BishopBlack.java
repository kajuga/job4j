package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (dest.x == source.x + 1 && dest.y == source.y + 1) {
            steps = new Cell[]{Cell.getCellByXAndY(dest.x, dest.y)};
        }
        if (dest.x == source.x + 2 && dest.y == source.y + 2) {
            steps = new Cell[dest.y - source.y];
            for (int y = source.y + 1, x = source.x + 1, i = 0; y <= dest.y && x<= dest.x; y++, x++, i++) {
                steps[i] = Cell.getCellByXAndY(x, y);
            }
        }
        if (dest.x == source.x + 3 && dest.y == source.y + 3) {
            steps = new Cell[dest.y - source.y];
            for (int y = source.y + 1, x = source.x + 1, i = 0; y <= dest.y && x <= dest.x; y++, x++, i++) {
                steps[i] = Cell.getCellByXAndY(x, y);
            }
        }
        if (dest.x == source.x + 4 && dest.y == source.y + 4) {
            steps = new Cell[dest.y - source.y];
            for (int y = source.y + 1, x = source.x + 1, i = 0; y <= dest.y && x <= dest.x; y++, x++, i++) {
                steps[i] = Cell.getCellByXAndY(x, y);
            }
        }
        if (dest.x == source.x + 5 && dest.y == source.y + 5) {
            steps = new Cell[dest.y - source.y];
            for (int y = source.y + 1, x = source.x + 1, i = 0; y <= dest.y && x <= dest.x; y++, x++, i++) {
                steps[i] = Cell.getCellByXAndY(x, y);
            }
        }
        if (dest.x == source.x + 6 && dest.y == source.y + 6) {
            steps = new Cell[dest.y - source.y];
            for (int y = source.y + 1, x = source.x + 1, i = 0; y <= dest.y && x <= dest.x; y++, x++, i++) {
                steps[i] = Cell.getCellByXAndY(x, y);
            }
        }
        if (dest.x == source.x + 7 && dest.y == source.y + 7) {
            steps = new Cell[dest.y - source.y];
            for (int y = source.y + 1, x = source.x + 1, i = 0; y <= dest.y && x <= dest.x; y++, x++, i++) {
                steps[i] = Cell.getCellByXAndY(x, y);
            }
        }
//=======================================================================================
        //тут какаято странная херня - не работает
        if (dest.x == source.x - 1 && dest.y == source.y - 1) {
            steps = new Cell[]{Cell.getCellByXAndY(dest.x, dest.y)};
        }

        if (dest.x == source.x - 2 && dest.y == source.y - 2) {
            steps = new Cell[source.y - dest.y];
            for (int y = source.y - 1, x = source.x - 1, i = 0; y >= dest.y && x >= dest.x; y--, x--, i++) {
                steps[i] = Cell.getCellByXAndY(x, y);
            }
        }

        if (dest.x == source.x - 3 && dest.y == source.y - 3) {
            steps = new Cell[source.y - dest.y];
            for (int y = source.y - 1, x = source.x - 1, i = 0; y >= dest.y && x >= dest.x; y--, x--, i++) {
                steps[i] = Cell.getCellByXAndY(x, y);
            }
        }

        if (dest.x == source.x - 4 && dest.y == source.y - 4) {
            steps = new Cell[source.y - dest.y];
            for (int y = source.y - 1, x = source.x - 1, i = 0; y >= dest.y && x >= dest.x; y--, x--, i++) {
                steps[i] = Cell.getCellByXAndY(x, y);
            }
        }

        if (dest.x == source.x - 5 && dest.y == source.y - 5) {
            steps = new Cell[source.y - dest.y];
            for (int y = source.y - 1, x = source.x - 1, i = 0; y >= dest.y && x >= dest.x; y--, x--, i++) {
                steps[i] = Cell.getCellByXAndY(x, y);
            }
        }

        if (dest.x == source.x - 6 && dest.y == source.y - 6) {
            steps = new Cell[source.y - dest.y];
            for (int y = source.y - 1, x = source.x - 1, i = 0; y >= dest.y && x >= dest.x; y--, x--, i++) {
                steps[i] = Cell.getCellByXAndY(x, y);
            }
        }
        if (dest.x == source.x - 7 && dest.y == source.y - 7) {
            steps = new Cell[source.y - dest.y];
            for (int y = source.y - 1, x = source.x - 1, i = 0; y >= dest.y || x >= dest.x; y--, x--, i++) {
                steps[i] = Cell.getCellByXAndY(x, y);
            }
        }

//=====================================================================================================
        if (dest.x == source.x + 1 && dest.y == source.y - 1) {
            steps = new Cell[]{Cell.getCellByXAndY(dest.x, dest.y)};
        }

        if (dest.x == source.x + 2 && dest.y == source.y - 2) {
            steps = new Cell[source.y - dest.y];
            for (int y = source.y - 1, x = source.x + 1, i = 0; y >= dest.y && x <= dest.x; y--, x++, i++) {
                steps[i] = Cell.getCellByXAndY(x, y);
            }
        }


        if (dest.x == source.x + 3 && dest.y == source.y - 3) {
            steps = new Cell[source.y - dest.y];
            for (int y = source.y - 1, x = source.x + 1, i = 0; y >= dest.y && x <= dest.x; y--, x++, i++) {
                steps[i] = Cell.getCellByXAndY(x, y);
            }
        }
        if (dest.x == source.x + 4 && dest.y == source.y - 4) {
            steps = new Cell[source.y - dest.y];
            for (int y = source.y - 1, x = source.x + 1, i = 0; y >= dest.y && x <= dest.x; y--, x++, i++) {
                steps[i] = Cell.getCellByXAndY(x, y);
            }
        }
        if (dest.x == source.x + 5 && dest.y == source.y - 5) {
            steps = new Cell[source.y - dest.y];
            for (int y = source.y - 1, x = source.x + 1, i = 0; y >= dest.y && x <= dest.x; y--, x++, i++) {
                steps[i] = Cell.getCellByXAndY(x, y);
            }
        }
        if (dest.x == source.x + 6 && dest.y == source.y - 6) {
            steps = new Cell[source.y - dest.y];
            for (int y = source.y - 1, x = source.x + 1, i = 0; y >= dest.y && x <= dest.x; y--, x++, i++) {
                steps[i] = Cell.getCellByXAndY(x, y);
            }
        }
        if (dest.x == source.x + 7 && dest.y == source.y - 7) {
            steps = new Cell[source.y - dest.y];
            for (int y = source.y - 1, x = source.x + 1, i = 0; y >= dest.y && x <= dest.x; y--, x++, i++) {
                steps[i] = Cell.getCellByXAndY(x, y);
            }
        }
//======================================================================================================
        if (dest.x == source.x - 1 && dest.y == source.y + 1) {
            steps = new Cell[]{Cell.getCellByXAndY(dest.x, dest.y)};
        }
        if (dest.x == source.x - 2 && dest.y == source.y + 2) {
            steps = new Cell[source.x - dest.x];
            for (int y = source.y + 1, x = source.x - 1, i = 0; y <= dest.y && x >= dest.x; y++, x--, i++) {
                steps[i] = Cell.getCellByXAndY(x, y);
            }
        }
        if (dest.x == source.x - 3 && dest.y == source.y + 3) {
            steps = new Cell[source.x - dest.x];
            for (int y = source.y + 1, x = source.x - 1, i = 0; y <= dest.y && x >= dest.x; y++, x--, i++) {
                steps[i] = Cell.getCellByXAndY(x, y);
            }
        }
        if (dest.x == source.x - 4 && dest.y == source.y + 4) {
            steps = new Cell[source.x - dest.x];
            for (int y = source.y + 1, x = source.x - 1, i = 0; y <= dest.y && x >= dest.x; y++, x--, i++) {
                steps[i] = Cell.getCellByXAndY(x, y);
            }
        }
        if (dest.x == source.x - 5 && dest.y == source.y + 5) {
            steps = new Cell[source.x - dest.x];
            for (int y = source.y + 1, x = source.x - 1, i = 0; y <= dest.y && x >= dest.x; y++, x--, i++) {
                steps[i] = Cell.getCellByXAndY(x, y);
            }
        }
        if (dest.x == source.x - 6 && dest.y == source.y + 6) {
            steps = new Cell[source.x - dest.x];
            for (int y = source.y + 1, x = source.x - 1, i = 0; y <= dest.y && x >= dest.x; y++, x--, i++) {
                steps[i] = Cell.getCellByXAndY(x, y);
            }
        }
        if (dest.x == source.x - 7 && dest.y == source.y + 7) {
            steps = new Cell[source.x - dest.x];
            for (int y = source.y + 1, x = source.x - 1, i = 0; y <= dest.y && x >= dest.x; y++, x--, i++) {
                steps[i] = Cell.getCellByXAndY(x, y);
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
