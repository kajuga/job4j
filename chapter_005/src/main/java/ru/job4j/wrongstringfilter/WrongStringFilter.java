package ru.job4j.wrongstringfilter;

import java.io.*;
import java.util.Scanner;

/**
 * Реализация функционала фильтрации строкового потока
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 */
public class WrongStringFilter {

    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        try {
            Scanner scanner = new Scanner(in);
            while (scanner.hasNext()) {
                String temp = scanner.next();
                boolean isAbuse = false;
                for (int i = 0; i < abuse.length; i++) {
                    if (abuse[i].equals(temp)) {
                        isAbuse = true;
                    }
                }
                if (!isAbuse) {
                    temp += " ";
                    out.write(temp.getBytes());
                }
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}