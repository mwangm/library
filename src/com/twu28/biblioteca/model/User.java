package com.twu28.biblioteca.model;

public class User {
    private String ID;
    private String password;

    public User(String ID, String password) {
        this.ID = ID;
        this.password = password;
    }

    public boolean isEqual(User user) {
        return this.ID.equals(user.ID) && this.password.equals(user.password);
    }

}

