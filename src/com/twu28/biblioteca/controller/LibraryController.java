package com.twu28.biblioteca.controller;

import com.twu28.biblioteca.console.IConsole;
import com.twu28.biblioteca.service.LibraryService;
import com.twu28.biblioteca.service.LoginService;
import com.twu28.biblioteca.action.*;
import com.twu28.biblioteca.model.Book;
import com.twu28.biblioteca.model.Movie;

import java.util.List;

public class LibraryController {
    private IConsole console;
    private LibraryService libraryService;
    private LoginService loginService;

    public LibraryController(IConsole console, LibraryService libraryService, LoginService loginService) {
        this.console = console;
        this.libraryService = libraryService;
        this.loginService = loginService;
    }

    public void showWelcome() {
        responseToUser("Welcome to use the public library system");
    }

    public void displayMenu() {
        console.output(ActionFactory.getActionList());
    }

    public boolean playActions(int selectedOption) {
        IAction action = ActionFactory.createAction(selectedOption);
        action.playAction(this);
        return action instanceof ExitAction ? false :true;
    }

    public Boolean login(String id, String password) {
        return loginService.login(id, password);
    }

    public void logout() {
        loginService.logout();
    }

    public String getAllBooks() {
        List<Book> allBooks = libraryService.getAllBooks();
        StringBuilder booklist = new StringBuilder();
        for (Book book : allBooks) {
            booklist.append(book.toString()).append("\n");
        }
        return booklist.toString();
    }

    public boolean reserveBook(String bookId) {
        return libraryService.reserveBook(Integer.parseInt(bookId));
    }

    public String getAllMovies() {
        List<Movie> allMovies = libraryService.getAllMovies();
        StringBuilder movieList = new StringBuilder();
        for (Movie movie : allMovies) {
            movieList.append(movie.toString()).append("\n");
        }
        return movieList.toString();
    }

    public String getUserInput() {
        return console.getInput();
    }

    public void responseToUser(String message) {
        console.output(message);
    }

    public boolean isUserHaveBeenLogin() {
        return loginService.isUserLogin();
    }
}
