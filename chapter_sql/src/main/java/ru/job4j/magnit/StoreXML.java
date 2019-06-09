package ru.job4j.magnit;

import ru.job4j.magnit.entity.Entry;

import java.io.File;
import java.util.List;

public class StoreXML {

    private File target;

    public StoreXML(File target) {
        this.target = target;
    }

    public boolean save(List<Entry> list) {

        return true;
    }
}
