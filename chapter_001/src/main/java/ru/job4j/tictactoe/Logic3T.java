package ru.job4j.tictactoe;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        return isWinnerXByHorizontal() || isWinnerXByVertical() || isWinnerXByDiagonalLeftToRight() || isWinnerXByDiagonalRightToLeft();
    }

    public boolean isWinnerO() {
        return isWinnerOByHorizontal() || isWinnerOByVertical() || isWinnerOByDiagonalLeftToRight() || isWinnerOByDiagonalRightToLeft();
    }

    public boolean hasGap() {
        boolean huylean = false;
        for (int i = 0; i < table.length; i++) {
            for (int k = 0; k < table.length; k++) {
                if (!(table[k][i].hasMarkO()) && !table[k][i].hasMarkO()) {
                    huylean = true;
                }
            }
        }
        return huylean;
    }

    private boolean isWinnerXByHorizontal() {
        boolean isWinner = false;
        for (int i = 0; i < table.length; i++) {
            isWinner = true;
            for (int k = 0; k < table[i].length; k++) {
                if (!table[i][k].hasMarkX()) {
                    isWinner = false;
                    break;
                }
            }
            if (isWinner) {
                break;
            }
        }
        return isWinner;
    }

    private boolean isWinnerXByVertical() {
        boolean isWinner = false;
        for (int j = 0; j < table.length; j++) {
            isWinner = true;
            for (int k = 0; k < table.length; k++) {
                if (!table[k][j].hasMarkX()) {
                    isWinner = false;
                    break;
                }
            }
            if (isWinner) {
                break;
            }
        }
        return isWinner;
    }

    private boolean isWinnerXByDiagonalLeftToRight() {
        boolean isWinner = true;
        for (int k = 0; k < table.length; k++) {
            if (!table[k][k].hasMarkX()) {
                isWinner = false;
                break;
            }
        }
        return isWinner;
    }

    private boolean isWinnerXByDiagonalRightToLeft() {
        boolean isWinner = true;
        for (int k = 0; k < table.length; k++) {
            if (!table[k][table.length - k - 1].hasMarkX()) {
                isWinner = false;
                break;
            }
        }
        return isWinner;
    }

    private boolean isWinnerOByHorizontal() {
        boolean isWinner = false;
        for (int i = 0; i < table.length; i++) {
            isWinner = true;
            for (int k = 0; k < table[i].length; k++) {
                if (!table[i][k].hasMarkO()) {
                    isWinner = false;
                    break;
                }
            }
            if (isWinner) {
                break;
            }
        }
        return isWinner;
    }

    private boolean isWinnerOByVertical() {
        boolean isWinner = false;
        for (int j = 0; j < table.length; j++) {
            isWinner = true;
            for (int k = 0; k < table.length; k++) {
                if (!table[k][j].hasMarkO()) {
                    isWinner = false;
                    break;
                }
            }
            if (isWinner) {
                break;
            }
        }
        return isWinner;
    }

    private boolean isWinnerOByDiagonalLeftToRight() {
        boolean isWinner = true;
        for (int k = 0; k < table.length; k++) {
            if (!table[k][k].hasMarkO()) {
                isWinner = false;
                break;
            }
        }
        return isWinner;
    }

    private boolean isWinnerOByDiagonalRightToLeft() {
        boolean isWinner = true;
        for (int k = 0; k < table.length; k++) {
            if (!table[k][table.length - k - 1].hasMarkO()) {
                isWinner = false;
                break;
            }
        }
        return isWinner;
    }

}