package ru.job4j.loop;

public class Board {
    public static String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 1; i <= height; i++) {
            if (i % 2 == 0) {
                for (int k = 1; k <= width; k++) {
                    if (k % 2 == 0) {
                        screen.append("x");
                    } else {
                        screen.append(" ");
                    }
                }
                screen.append(ln);
            } else {
                for (int k = 1; k <= width; k++) {
                    if (k % 2 != 0) {
                        screen.append("x");
                    } else {
                        screen.append(" ");
                    }
                }
                screen.append(ln);
            }
        }
        return screen.toString();
    }
}