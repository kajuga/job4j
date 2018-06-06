package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class RookBlack implements Figure {
    private final Cell position;

    public RookBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell [] steps = new Cell[0];
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
        if (source.y == dest.y){
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
        return new RookBlack(dest);
    }
}
