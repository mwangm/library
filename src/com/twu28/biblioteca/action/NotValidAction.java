package com.twu28.biblioteca.action;

import com.twu28.biblioteca.controller.LibraryController;

public class NotValidAction implements IAction {
    @Override
    public void playAction(LibraryController libraryController) {
        libraryController.responseToUser("please select a valid option!\n");
    }

    @Override
    public int getActionCode() {
        return -1;
    }

    @Override
    public String getDescription() {
        return "";
    }
}
