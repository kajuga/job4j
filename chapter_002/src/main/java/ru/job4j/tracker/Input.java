package ru.job4j.tracker;

import java.io.IOException;

public interface Input {
    String ask(String question) throws IOException;

    int ask(String question, int[] range);
}