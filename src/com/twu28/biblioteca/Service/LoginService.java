package com.twu28.biblioteca.service;

import com.twu28.biblioteca.model.User;

import java.util.ArrayList;
import java.util.List;

public class LoginService {
    private  List<User> users;
    private User currentUser;

    public LoginService() {
        users = new ArrayList<User>();
        initialUserList();
    }

    private void initialUserList() {
        users.add(new User("1", "password"));
        users.add(new User("2", "password"));
        users.add(new User("3", "password"));
    }

    public Boolean login(String libraryNumber, String password) {
        User userWantToLogin = new User(libraryNumber, password);
        for (User user : users) {
            if (user.isEqual(userWantToLogin)) {
                setCurrentUser(user);
                return true;
            }
        }
        return false;
    }

    public void logout() {
        this.currentUser = null;
    }

    private void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
