package ru.job4j.tracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput implements Input {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String ask(String question) throws IOException {
        System.out.print(question);
        return reader.readLine();
    }
}