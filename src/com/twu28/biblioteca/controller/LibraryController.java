package com.twu28.biblioteca.controller;

import com.twu28.biblioteca.Console.IConsole;
import com.twu28.biblioteca.action.*;
import com.twu28.biblioteca.model.Book;
import com.twu28.biblioteca.model.LibraryResource;
import com.twu28.biblioteca.model.Movie;

import java.util.List;

public class LibraryController {
    private IConsole console;
    private LibraryResource libraryResource;
    private LoginService loginService;

    public LibraryController(IConsole console, LibraryResource libraryResource, LoginService loginService) {
        this.console = console;
        this.libraryResource = libraryResource;
        this.loginService = loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public void showWelcome() {
        responseToUser("Welcome to use the public library system");
    }

    public void displayMenu() {
        String menu = "1:View all books\n2:Reserve a book\n3:Check Your Library Number\n4:show menu again\n5:show all movie\n6:login\n0:exit\nselect a option to go continued:";
        console.output(menu);
    }

    public void responseToUser(String message) {
        console.output(message);
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

    public List<Book> getAllBooks() {
        return libraryResource.getAllBooks();
    }

    public boolean reserveBook(String bookId) {
        return libraryResource.reserveBook(Integer.parseInt(bookId));
    }

    public String getUserInput() {
        return console.getInput();
    }

    public List<Movie> getAllMovies() {
        return libraryResource.getAllMovies();
    }
}
