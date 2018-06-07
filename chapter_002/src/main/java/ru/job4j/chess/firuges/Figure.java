package ru.job4j.chess.firuges;

public abstract class Figure {

    final Cell position;

    public Figure(Cell position) {
        this.position = position;
    }

    public Cell position() {
        return this.position;
    }

    /**
     * Метод должен работать так. dest - задает ячейку, куда следует пойти. Если фигура может туда пойти. то Вернуть массив ячеек. которые должна пройти фигура.
     * Если фигура туда пойти не может. выбросить исключение ImposibleMoveException
     */
    public abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    public String icon() {     //загрузка наших иизображений
        return String.format(
                "%s.png", this.getClass().getSimpleName()       //при помощи java reflection получаем картинку
        );

    }

    /**
     он должен создавать объект Figure с координатой Cell dest.
     Например. для класса
     class Bishop impl Figure {
     Figure copy(Cell dest) {
     return new Bishop(dest);
     }
     }
     */
    public abstract Figure copy(Cell dest); //он делает "перемещение" фигуры - фактически создает новую и перезаписывает ее нахождение

}