package ru.job4j.chess.firuges;

public interface Figure {
    Cell position();//возвращает текущую клетку которую занимает


    /**
     Метод должен работать так. dest - задает ячейку, куда следует пойти. Если фигура может туда пойти. то Вернуть массив ячеек. которые должна пройти фигура.
     Если фигура туда пойти не может. выбросить исключение ImposibleMoveException
     */
    Cell[] way(Cell source, Cell dest);

    default String icon() {     //загрузка наших иизображений
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
    Figure copy(Cell dest); //он делает "перемещение" фигуры - фактически создает новую и перезаписывает ее нахождение

}
