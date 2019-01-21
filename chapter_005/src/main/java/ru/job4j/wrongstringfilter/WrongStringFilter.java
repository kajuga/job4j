package ru.job4j.wrongstringfilter;

import java.io.*;
import java.util.Arrays;

/**
 * Реализация функционала фильтрации строкового потока
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 */
public class WrongStringFilter {

    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out))) {
            while (br.ready()) {
                String stringLine = br.readLine();
                for (String str : stringLine.split("\\W")) {
                    if (Arrays.stream(abuse).noneMatch(x -> str.equals(x))) {
                        bw.write(str + " ");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        } catch (NullPointerException e) {
            throw e;
        }
    }
}