package com.twu28.biblioteca.action;

import com.twu28.biblioteca.controller.LibraryController;

public class ShowMoviesAction implements IAction {

    @Override
    public void playAction(LibraryController libraryController) {
        libraryController.responseToUser(libraryController.getAllMovies());
    }

}
