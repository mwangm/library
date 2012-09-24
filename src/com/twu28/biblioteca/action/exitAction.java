package com.twu28.biblioteca.action;

import com.twu28.biblioteca.controller.LibraryController;

public class ExitAction implements IAction{

    @Override
    public void playAction(LibraryController libraryController) {
        libraryController.logout();
        libraryController.responseToUser("bye~\n");
    }
}
