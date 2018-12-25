package ru.job4j.nonblockingcache;

/**
 * Class Base with getters, setters and other stuff;
 */

public class Base {
    private String name;
    private int id;
    private int ver;

    /**
     * constructor
     * @param id
     * @param name
     */
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

    public void setVer(int ver) {
        this.ver = ver;
    }

    public int countVersion(){
       return ver++;
    }
}
