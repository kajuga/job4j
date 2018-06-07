package ru.job4j.chess;

import ru.job4j.chess.firuges.*;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Board board = new Board();

    public void add(Figure figure) {
        board.add(figure);
    }

    public boolean move(Cell source, Cell dest) {
        try {
            return board.move(source, dest);
        }catch (ImpossibleMoveException | OccupiedWayException | FigureNotFoundException e){
            System.out.println("Фигура так ходить не может!");
            return false;
        }
    }

    public void clean() {
        board.clean();
    }
}
