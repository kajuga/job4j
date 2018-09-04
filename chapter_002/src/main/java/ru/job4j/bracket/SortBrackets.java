package ru.job4j.bracket;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Позапихивал в названиях префикс "my" - чтобы в коде не путаться, в финале переделаю-уберу, знаю что неправильно.

/**
 * Парсер скобок
 * @author Fedorov Aleksander (msg2fedorov@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class SortBrackets {

    /**
     * Константы:
     * SQUARE_BRACKETS - квадраные скобки
     * ROUND_BRACKETS - круглые скобки
     * SQUIGGLY_BRACKETS_BRACKETS - фигурные скобки
     */
    private final static String SQUARE_BRACKETS = "[]";
    private final static String ROUND_BRACKETS = "()";
    private final static String SQUIGGLY_BRACKETS = "{}";

    public static void main(String[] args) {
        String str = new String("([]{}{{}})");
        System.out.println("The string is: " + str);

        try {
            SortBrackets mySortBrackets = new SortBrackets();
            List<Bracket> brackets = mySortBrackets.myParserBrackets(str);
            for (Bracket bracket : brackets) {
                System.out.println("Скобка вида " + bracket.getSymbol() + ": " + "нач. позиция = "
                        + bracket.getBegin() + "; " + "кон. позиция = "
                        + bracket.getEnd() + ".");
            }
        } catch (NoValidException e) {
            System.out.println("Строка не валидна");
        }
    }

    /**
     * Method myParserBrackets возвращает список объектов-скобок с полями-позициями (нач. и кон.) в виде строки и стринговым полем,
     * указывающим на тип скобки (одна из констант класса)
     */
    public List<Bracket> myParserBrackets(String string) throws NoValidException {
        char[] symbols = string.toCharArray();
        Stack<Bracket> stackSquare = new Stack<>();
        Stack<Bracket> stackSquiggly = new Stack<>();
        Stack<Bracket> stackRound = new Stack<>();
        List<Bracket> result = new ArrayList<>();

        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i] == '[') {
                Bracket myBracket = new Bracket(SQUARE_BRACKETS, i); //создал скобку в конструктор к ней запхнул "[], i"
                stackSquare.push(myBracket);                         //запушил скобку в стек с начальной позицией (i)
            } else if (symbols[i] == ']' && stackSquare.empty()) {
                throw new NoValidException();
            } else if (symbols[i] == ']' && !stackSquare.empty()) {
                Bracket endSquare = stackSquare.pop();              //создаю ссылку на выдранную из стека скобку типа ("[]", i)
                if (endSquare != null && endSquare.getSymbol().equals(SQUARE_BRACKETS)) {   //ежели она соответствует [] то
                    endSquare.setEnd(i);            //у ранее выдратой из стека скобки задаю end
                    result.add(endSquare);          //вот тут не совсем понял ЧТО ИМЕННО добавляется в итоговый List<Bracket> result
                }
            }
            if (symbols[i] == '(') {
                Bracket myBracket = new Bracket(ROUND_BRACKETS, i);
                stackRound.push(myBracket);
            } else if (symbols[i] == ')' && stackRound.empty()) {
                throw new NoValidException();
            } else if (symbols[i] == ')' && !stackRound.empty()) {
                Bracket endRound = stackRound.pop();
                if (endRound != null && endRound.getSymbol().equals(ROUND_BRACKETS)) {
                    endRound.setEnd(i);
                    result.add(endRound);
                }
            }
            if (symbols[i] == '{') {
                Bracket myBracket = new Bracket(SQUIGGLY_BRACKETS, i);
                stackSquiggly.push(myBracket);
            } else if (symbols[i] == '}' && stackSquiggly.empty()) {
                throw new NoValidException();
            } else if (symbols[i] == '}' && !stackSquiggly.empty()) {
                Bracket endSquiggly = stackSquiggly.pop();
                if (endSquiggly != null && endSquiggly.getSymbol().equals(SQUIGGLY_BRACKETS)) {
                    endSquiggly.setEnd(i);
                    result.add(endSquiggly);
                }
            }
        }
        if (stackSquare.size() != 0) {
            throw new NoValidException();
        }
        if (stackRound.size() != 0) {
            throw new NoValidException();
        }
        if (stackSquiggly.size() != 0) {
            throw new NoValidException();
        }
        return result;
    }
}