package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class KnightWhite implements Figure {
    private final Cell position;

    public KnightWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }
/**
 * Сыпется когда поставишь на неверную клетку! в остальном работает
 *
 */
//    @Override
//    public Cell[] way(Cell source, Cell dest) {
//        Cell [] steps = new Cell[1];
//        if (dest.x == source.x + 1 && dest.y == source.y + 2) {
//            steps[0] = Cell.getCellByXAndY(dest.x, dest.y);
//        }
//        if (dest.x == source.x - 1 && dest.y == source.y + 2) {
//            steps[0] = Cell.getCellByXAndY(dest.x, dest.y);
//        }
//        if (dest.x == source.x + 1 && dest.y == source.y - 2) {
//            steps[0] = Cell.getCellByXAndY(dest.x, dest.y);
//        }
//        if (dest.x == source.x - 1 && dest.y == source.y - 2) {
//            steps[0] = Cell.getCellByXAndY(dest.x, dest.y);
//        }
//        if (dest.x == source.x + 2 && dest.y == source.y - 1) {
//            steps[0] = Cell.getCellByXAndY(dest.x, dest.y);
//        }
//        if (dest.x == source.x - 2 && dest.y == source.y - 1) {
//            steps[0] = Cell.getCellByXAndY(dest.x, dest.y);
//        }
//        if (dest.x == source.x + 2 && dest.y == source.y + 1) {
//            steps[0] = Cell.getCellByXAndY(dest.x, dest.y);
//        }
//        if (dest.x == source.x - 2 && dest.y == source.y + 1) {
//            steps[0] = Cell.getCellByXAndY(dest.x, dest.y);
//        }
//        return steps;
//    }

    /**
     * СТАРЫЙ ВАРИАНТ, который не сыпется изза некоректной перестановки, работает
     * @param dest
     * @return
     */
    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (dest.x == source.x + 1 && dest.y == source.y - 2){
            steps = new Cell[]{Cell.getCellByXAndY(dest.x, dest.y)};
        }
        else if (dest.x == source.x - 1 && dest.y == source.y - 2){
            steps = new Cell[]{Cell.getCellByXAndY(dest.x, dest.y)};
        }
        else if (dest.x == source.x + 2 && dest.y == source.y - 1) {
            steps = new Cell[]{Cell.getCellByXAndY(dest.x, dest.y)};
        }
        else if (dest.x == source.x - 2 && dest.y == source.y - 1) {
            steps = new Cell[]{Cell.getCellByXAndY(dest.x, dest.y)};
        }
        else if (dest.x == source.x + 2 && dest.y == source.y + 1) {
            steps = new Cell[]{Cell.getCellByXAndY(dest.x, dest.y)};
        }
        else if (dest.x == source.x - 2 && dest.y == source.y + 1) {
            steps = new Cell[]{Cell.getCellByXAndY(dest.x, dest.y)};
        }
        else if (dest.x == source.x - 1 && dest.y == source.y + 2) {
            steps = new Cell[]{Cell.getCellByXAndY(dest.x, dest.y)};
        }
        else if (dest.x == source.x + 1 && dest.y == source.y + 2) {
            steps = new Cell[]{Cell.getCellByXAndY(dest.x, dest.y)};
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightWhite(dest);
    }
}
