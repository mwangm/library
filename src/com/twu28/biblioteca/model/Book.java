package com.twu28.biblioteca.model;

public class Book {
    private int id;
    private String name;

    public Book(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "ID:" + this.id + " Name:" + this.name;
    }
}
