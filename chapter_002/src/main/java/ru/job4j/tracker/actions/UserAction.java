package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;

import java.io.IOException;

public interface UserAction {
    int key();
    void execute(Input input, Tracker tracker)throws IOException;
    String info();
}