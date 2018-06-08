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
/*
Вы должны поймать исключение только в том случае, если у вас есть стратегия для его фактической обработки. Пока ее у меня нет.
 */
    public boolean move(Cell source, Cell dest) {
        try {
            return board.move(source, dest);
        } catch (ImpossibleMoveException e) {
            System.out.println("Фигура так ходить не может!, ловим ImpossibleMoveException");
        } catch (OccupiedWayException e) {
            System.out.println("Фигура так ходить не может!, ловим OccupiedWayException");
        } catch (FigureNotFoundException e) {
            System.out.println("Фигура так ходить не может!, ловим FigureNotFoundException");
        }
        return false;
    }


    public void clean() {
        board.clean();
    }
}
