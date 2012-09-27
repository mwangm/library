package com.twu28.biblioteca.action;

import com.twu28.biblioteca.controller.LibraryController;

public class ReserveBookAction implements IAction {

    @Override
    public void playAction(LibraryController libraryController) {
        if(!libraryController.isUserHaveBeenLogin()) {
            libraryController.responseToUser("please login first before you reserve book\n");
            return;
        }

        libraryController.responseToUser("please enter the id of the book you want:");
        String bookId = libraryController.getUserInput();
        if (libraryController.reserveBook(bookId))
            libraryController.responseToUser("Thank You! Enjoy the book.\n");
        else
            libraryController.responseToUser("Sorry we don't have that book yet.\n");
    }

    @Override
    public int getActionCode() {
        return 2;
    }

    @Override
    public String getDescription() {
        return "Reserve a book";
    }

}
