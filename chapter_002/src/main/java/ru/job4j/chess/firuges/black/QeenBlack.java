package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class QeenBlack implements Figure {
    private final Cell position;

    public QeenBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];

        /**
         * Перемещение строго по горизонтали или вертикали (взял из турочки - RookBlack)
         */
        if (source.x == dest.x || source.y == dest.y) {
            steps = new Cell[]{dest};
        }

/**
 * Диагональ слева-направо в вверх (содрал у bishop)
 */
        if (dest.x == source.x + 1 && dest.y == source.y - 1) {
            steps = new Cell[]{dest};
        }
        if (dest.x == source.x + 2 && dest.y == source.y - 2) {
            steps = new Cell[]{dest};
        }
        if (dest.x == source.x + 3 && dest.y == source.y - 3) {
            steps = new Cell[]{dest};
        }
        if (dest.x == source.x + 4 && dest.y == source.y - 4) {
            steps = new Cell[]{dest};
        }
        if (dest.x == source.x + 5 && dest.y == source.y - 5) {
            steps = new Cell[]{dest};
        }
        if (dest.x == source.x + 6 && dest.y == source.y - 6) {
            steps = new Cell[]{dest};
        }
        if (dest.x == source.x + 7 && dest.y == source.y - 7) {
            steps = new Cell[]{dest};
        }

/**
 * Диагональ справа-налево вниз (содрал у bishop)
 */
        if (dest.y == source.y + 1 && dest.x == source.x - 1) {
            steps = new Cell[]{dest};
        }
        if (dest.y == source.y + 2 && dest.x == source.x - 2) {
            steps = new Cell[]{dest};
        }
        if (dest.y == source.y + 3 && dest.x == source.x - 3) {
            steps = new Cell[]{dest};
        }
        if (dest.y == source.y + 4 && dest.x == source.x - 4) {
            steps = new Cell[]{dest};
        }
        if (dest.y == source.y + 5 && dest.x == source.x - 5) {
            steps = new Cell[]{dest};
        }
        if (dest.y == source.y + 6 && dest.x == source.x - 6) {
            steps = new Cell[]{dest};
        }
        if (dest.y == source.y + 7 && dest.x == source.x - 7) {
            steps = new Cell[]{dest};
        }

/**
 * Диагональ справа налево вверх (содрал у bishop)
 */
        if (dest.y == source.y - 1 && dest.x == source.x - 1) {
            steps = new Cell[]{dest};
        }
        if (dest.y == source.y - 2 && dest.x == source.x - 2) {
            steps = new Cell[]{dest};
        }
        if (dest.y == source.y - 3 && dest.x == source.x - 3) {
            steps = new Cell[]{dest};
        }
        if (dest.y == source.y - 4 && dest.x == source.x - 4) {
            steps = new Cell[]{dest};
        }
        if (dest.y == source.y - 5 && dest.x == source.x - 5) {
            steps = new Cell[]{dest};
        }
        if (dest.y == source.y - 6 && dest.x == source.x - 6) {
            steps = new Cell[]{dest};
        }
        if (dest.y == source.y - 7 && dest.x == source.x - 7) {
            steps = new Cell[]{dest};
        }

        /**
         * Диагональ слева направо сверху вниз (содрал у bishop)
         */
        if (dest.y == source.y + 1 && dest.x == source.x + 1) {
            steps = new Cell[]{dest};
        }
        if (dest.y == source.y + 2 && dest.x == source.x + 2) {
            steps = new Cell[]{dest};
        }
        if (dest.y == source.y + 3 && dest.x == source.x + 3) {
            steps = new Cell[]{dest};
        }
        if (dest.y == source.y + 4 && dest.x == source.x + 4) {
            steps = new Cell[]{dest};
        }
        if (dest.y == source.y + 5 && dest.x == source.x + 5) {
            steps = new Cell[]{dest};
        }
        if (dest.y == source.y + 6 && dest.x == source.x + 6) {
            steps = new Cell[]{dest};
        }
        if (dest.y == source.y + 7 && dest.x == source.x + 7) {
            steps = new Cell[]{dest};
        }

        return steps;
    }


    @Override
    public Figure copy(Cell dest) {
        return new QeenBlack(dest);
    }
}
