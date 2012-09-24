package com.twu28.biblioteca.action;

import com.twu28.biblioteca.controller.LibraryController;
import com.twu28.biblioteca.model.Movie;

import java.util.List;

public class ShowMoviesAction implements IAction {

    @Override
    public void playAction(LibraryController libraryController) {
        List<Movie> allMovies = libraryController.getAllMovies();
        StringBuilder booklist = new StringBuilder();
        for (Movie movie : allMovies) {
            booklist.append(movie.toString()).append("\n");
        }
        libraryController.responseToUser(booklist.toString());
    }

}
