package com.twu28.biblioteca.action;

import com.twu28.biblioteca.controller.LibraryController;

public class ShowBooksAction implements IAction{

    @Override
    public void playAction(LibraryController libraryController) {
        libraryController.responseToUser(libraryController.getAllBooks());
    }

    @Override
    public int getActionCode() {
        return 1;
    }

    @Override
    public String getDescription() {
        return "View all books";
    }

}
