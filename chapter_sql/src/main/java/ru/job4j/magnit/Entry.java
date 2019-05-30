package ru.job4j.magnit;

import static org.bitbucket.dollar.Dollar.$;

public class Entry {
    private final int indexNameLenghtGenerator = 12;
    private int id;
    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return randomString(indexNameLenghtGenerator);
    }

    public void setName(String name) {
        this.name = name;
    }

    private String validCharacters = $('0', '9').join() + $('A', 'Z').join();

    private String randomString(int length) {
        return $(validCharacters).shuffle().slice(length).toString();
    }

    @Override
    public String toString() {
        return "Entry{" +
                " id= " + id +
                ", name ='" + name + '\'' +
                '}' + "\n";
    }

    //    public static void main(String[] args) {
//        Entry e = new Entry();
//        Entry e2 = new Entry();
//        System.out.println(e.getName() + " " + e2.getName());
//    }
}
