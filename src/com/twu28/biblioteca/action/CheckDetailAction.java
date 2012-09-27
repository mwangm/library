package com.twu28.biblioteca.action;

import com.twu28.biblioteca.controller.LibraryController;

public class CheckDetailAction implements IAction{
    public void playAction(LibraryController libraryController) {
        libraryController.responseToUser("Please talk to Librarian. Thank you\n");
    }

    @Override
    public int getActionCode() {
        return 3;
    }

    @Override
    public String getDescription() {
        return "Check Your Library Number";
    }
}
