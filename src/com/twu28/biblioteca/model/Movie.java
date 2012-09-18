package com.twu28.biblioteca.model;

public class Movie {
    private int id;
    private String name;

    public Movie(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "ID:" + this.id + " Movie Name:" + this.name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
