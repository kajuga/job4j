package ru.job4j.nonblockingcache;

public class Base {
    String name;
    int id;
    int ver;

    public Base(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getVer() {
        return ver;
    }

    public void setName(String name) {
        this.name = name;
    }

    int countVersion(){
       return ver++;
    }
}
