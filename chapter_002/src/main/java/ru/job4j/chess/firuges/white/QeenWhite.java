package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class QeenWhite implements Figure {
    private final Cell position;

    public QeenWhite(final Cell position) {
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

        if (source.x == dest.x) {
            if (dest.y != source.y) {
                //вертикаль снизу вверх (если белые снизу!!!!!!)
                if (dest.y > source.y) {
                    steps = new Cell[dest.y - source.y];
                    for (int y = source.y + 1, i = 0; y <= dest.y; y++, i++) {
                        steps[i] = Cell.getCellByXAndY(source.x, y);
                    }
                } else {
                    //сверху вниз (если белые снизу)
                    steps = new Cell[source.y - dest.y];
                    for (int y = source.y - 1, i = 0; y >= dest.y; y--, i++) {
                        steps[i] = Cell.getCellByXAndY(source.x, y);
                    }
                }
            }
        }
        if (source.y == dest.y) {
            if (dest.x != source.x) {
                //горизонталь  - двигаемся слева направо (когда белые снизу)
                if (dest.x > source.x) {
                    steps = new Cell[dest.x - source.x];
                    for (int x = source.x + 1, i = 0; x <= dest.x; x++, i++) {
                        steps[i] = Cell.getCellByXAndY(x, source.y);
                    }
                } else {
                    //горизонталь справа налево (белые снизу)
                    steps = new Cell[source.x - dest.x];
                    for (int x = source.x - 1, i = 0; x >= dest.x; x--, i++) {
                        steps[i] = Cell.getCellByXAndY(x, source.y);
                    }
                }
            }
        }
        return steps;
    }







    @Override
    public Figure copy(Cell dest) {
        return new QeenWhite(dest);
    }
}
