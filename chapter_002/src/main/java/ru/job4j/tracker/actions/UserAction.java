package ru.job4j.tracker.actions;

import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Input;

import java.io.IOException;

public interface UserAction {
    int key();
    void execute(Input input, ITracker tracker)throws IOException;
    String info();
}