package ru.job4j.chess.firuges;

public enum Cell {
    A1(0, 0), A2(0, 1), A3(0, 2), A4(0, 3), A5(0, 4), A6(0, 5), A7(0, 6), A8(0, 7),
    B1(1, 0), B2(1, 1), B3(1, 2), B4(1, 3), B5(1, 4), B6(1, 5), B7(1, 6), B8(1, 7),
    C1(2, 0), C2(2, 1), C3(2, 2), C4(2, 3), C5(2, 4), C6(2, 5), C7(2, 6), C8(2, 7),
    D1(3, 0), D2(3, 1), D3(3, 2), D4(3, 3), D5(3, 4), D6(3, 5), D7(3, 6), D8(3, 7),
    E1(4, 0), E2(4, 1), E3(4, 2), E4(4, 3), E5(4, 4), E6(4, 5), E7(4, 6), E8(4, 7),
    F1(5, 0), F2(5, 1), F3(5, 2), F4(5, 3), F5(5, 4), F6(5, 5), F7(5, 6), F8(5, 7),
    G1(6, 0), G2(6, 1), G3(6, 2), G4(6, 3), G5(6, 4), G6(6, 5), G7(6, 6), G8(6, 7),
    H1(7, 0), H2(7, 1), H3(7, 2), H4(7, 3), H5(7, 4), H6(7, 5), H7(7, 6), H8(7, 7);

    public final int x;
    public final int y;

    Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Cell getCellByXAndY(int x, int y){
//Первая вертикалка
        if (x == 0 && y == 0){
            return A1;
        }
        if (x == 0 && y == 1){
            return A2;
        }
        if (x == 0 && y == 2){
            return A3;
        }
        if (x == 0 && y == 3){
            return A4;
        }
        if (x == 0 && y == 4){
            return A5;
        }
        if (x == 0 && y == 5){
            return A6;
        }
        if (x == 0 && y == 6){
            return A7;
        }
        if (x == 0 && y == 7){
            return A8;
        }
//Вторая
        if (x == 1 && y == 0){
            return B1;
        }
        if (x == 1 && y == 1){
            return B2;
        }
        if (x == 1 && y == 2){
            return B3;
        }
        if (x == 1 && y == 3){
            return B4;
        }
        if (x == 1 && y == 4){
            return B5;
        }
        if (x == 1 && y == 5){
            return B6;
        }
        if (x == 1 && y == 6){
            return B7;
        }
        if (x == 1 && y == 7){
            return B8;
        }
//Третья
        if (x == 2 && y == 0){
            return C1;
        }
        if (x == 2 && y == 1){
            return C2;
        }
        if (x == 2 && y == 2){
            return C3;
        }
        if (x == 2 && y == 3){
            return C4;
        }
        if (x == 2 && y == 4){
            return C5;
        }
        if (x == 2 && y == 5){
            return C6;
        }
        if (x == 2 && y == 6){
            return C7;
        }
        if (x == 2 && y == 7){
            return C8;
        }
//Четвертый
        if (x == 3 && y == 0){
            return D1;
        }
        if (x == 3 && y == 1){
            return D2;
        }
        if (x == 3 && y == 2){
            return D3;
        }
        if (x == 3 && y == 3){
            return D4;
        }
        if (x == 3 && y == 4){
            return D5;
        }
        if (x == 3 && y == 5){
            return D6;
        }
        if (x == 3 && y == 6){
            return D7;
        }
        if (x == 3 && y == 7){
            return D8;
        }

// 5
        if (x == 4 && y == 0){
            return E1;
        }
        if (x == 4 && y == 1){
            return E2;
        }
        if (x == 4 && y == 2){
            return E3;
        }
        if (x == 4 && y == 3){
            return E4;
        }
        if (x == 4 && y == 4){
            return E5;
        }
        if (x == 4 && y == 5){
            return E6;
        }
        if (x == 4 && y == 6){
            return E7;
        }
        if (x == 4 && y == 7){
            return E8;
        }
//6
        if (x == 5 && y == 0){
            return F1;
        }
        if (x == 5 && y == 1){
            return F2;
        }
        if (x == 5 && y == 2){
            return F3;
        }
        if (x == 5 && y == 3){
            return F4;
        }
        if (x == 5 && y == 4){
            return F5;
        }
        if (x == 5 && y == 5){
            return F6;
        }
        if (x == 5 && y == 6){
            return F7;
        }
        if (x == 5 && y == 7){
            return F8;
        }
//7
        if (x == 6 && y == 0){
            return G1;
        }
        if (x == 6 && y == 1){
            return G2;
        }
        if (x == 6 && y == 2){
            return G3;
        }
        if (x == 6 && y == 3){
            return G4;
        }
        if (x == 6 && y == 4){
            return G5;
        }
        if (x == 6 && y == 5){
            return G6;
        }
        if (x == 6 && y == 6){
            return G7;
        }
        if (x == 6 && y == 7){
            return G8;
        }
//8

        if (x == 7 && y == 0){
            return H1;
        }
        if (x == 7 && y == 1){
            return H2;
        }
        if (x == 7 && y == 2){
            return H3;
        }
        if (x == 7 && y == 3){
            return H4;
        }
        if (x == 7 && y == 4){
            return H5;
        }
        if (x == 7 && y == 5){
            return H6;
        }
        if (x == 7 && y == 6){
            return H7;
        }
        if (x == 7 && y == 7){
            return H8;
        }

        return null;
    }
}
