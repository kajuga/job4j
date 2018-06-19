package ru.job4j.bracket;

/**
 * Bracket - скобки
 * @author Fedorov Aleksander (msg2fedorov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Bracket {

    /**
     * Значок скобки
     */
    private String symbol;

    /**
     * Открывающая скобка
     */
    private int begin;

    /**
     * Закрывающая скобка
     */
    private int end;

    /**
     * Конструктор
     * @param symbol
     * @param begin
     */
    public Bracket(String symbol, int begin) {
        this.symbol = symbol;
        this.begin = begin;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }

    public String getSymbol() {
        return symbol;
    }
}