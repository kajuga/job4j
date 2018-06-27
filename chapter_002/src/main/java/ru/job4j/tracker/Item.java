package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;

public class Item {
    private String id;
    private String name;
    private String desc;
    private long created;
    private ArrayList<String> comments;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Item(String name, String desc, long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
    }

    public Item(String name, String desc, long created, ArrayList<String> comments) {
        this.name = name;
        this.desc = desc;
        this.created = created;
        this.comments = comments;
    }

    public Item(String name, ArrayList<String> comments) {
        this.name = name;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Item{"
                + "id='"
                + id + '\''
                + ", name='" + name
                + '\''
                + ", desc='"
                + desc
                + '\''
                + ", created="
                + created
                + ", comments="
                + comments
                + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }
}