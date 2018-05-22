package ru.job4j.tracker;

import java.io.IOException;

public interface UserAction {
    int key();
    void execute(Input input, Tracker tracker) throws IOException;
    String info();
}