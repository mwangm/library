package com.twu28.biblioteca.action;

import com.twu28.biblioteca.controller.LibraryController;

public class LoginAction implements IAction{

    @Override
    public void playAction(LibraryController libraryController) {
        libraryController.responseToUser("please enter you library user id:");
        String id = libraryController.getUserInput();
        libraryController.responseToUser("please enter you password:");
        String password = libraryController.getUserInput() ;

        if (libraryController.login(id, password)){
            libraryController.responseToUser("log in successful\n");
            return;
        }
        libraryController.responseToUser("invalid id or password\n");
    }

    @Override
    public int getActionCode() {
        return 6;
    }

    @Override
    public String getDescription() {
        return "login";
    }
}
