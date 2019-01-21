package ru.job4j.wrongstringfilter;

import java.io.*;

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
                for (String str : abuse) {
                    stringLine = stringLine.replaceAll(str + " ", "");             //с регулярными выражениями мучался-мучался в итоге вот так вот оставил
                }
                bw.write(stringLine);
            }
        } catch (IOException e) {
            System.out.println(e);
        } catch (NullPointerException e) {
            throw e;
        }
    }
}