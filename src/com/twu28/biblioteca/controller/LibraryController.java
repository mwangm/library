package com.twu28.biblioteca.controller;

import com.twu28.biblioteca.Console.IConsole;
import com.twu28.biblioteca.model.Book;
import com.twu28.biblioteca.model.LibraryResource;
import com.twu28.biblioteca.model.Movie;

import java.util.List;

public class LibraryController {
    private IConsole console;

    private LibraryResource libraryResource;

    private LoginService loginService;

    public LibraryController(IConsole console) {
        this.console = console;
        this.libraryResource = new LibraryResource();
        loginService = new LoginService();
    }

    public void setLibraryResource(LibraryResource libraryResource) {
        this.libraryResource = libraryResource;
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

    private void responseToUser(String message) {
        console.output(message);
    }
    //todo refactor
    public boolean playActions(int selectedOption) {
        boolean continued = true;
        switch (selectedOption) {
            case 1:
                showBookList();
                break;
            case 2:
                reserveBook();
                break;
            case 3:
                checkDetails();
                break;
            case 4:
                displayMenu();
                break;
            case 5:
                showMovieList();
                break;
            case 6:
                login();
                break;
            case 0:
                 exit();
                 continued=false;
                 break;
            default:responseToUser("please select a valid option!\n");
        }
        return continued;
    }

    private void login() {
        responseToUser("please enter you library user id:");
        String id = console.getInput();
        responseToUser("please enter you password:");
        String password = console.getInput() ;

        if (loginService.login(id, password)){
            responseToUser("log in successful\n");
            return;
        }
        responseToUser("invalid id or password\n");
    }

    private void showMovieList() {
        List<Movie> allMovies = libraryResource.getAllMovies();
        StringBuilder booklist = new StringBuilder();
        for (Movie movie : allMovies) {
            booklist.append(movie.toString()).append("\n");
        }
        responseToUser(booklist.toString());
    }

    private void exit() {
        responseToUser("bye~\n");
    }

    private void checkDetails() {
        responseToUser("Please talk to Librarian. Thank you\n");
    }

    private void showBookList() {
        List<Book> allBooks = libraryResource.getAllBooks();
        StringBuilder booklist = new StringBuilder();
        for (Book book : allBooks) {
            booklist.append(book.toString()).append("\n");
        }
        responseToUser(booklist.toString());
    }

    private void reserveBook() {
        responseToUser("please enter the id of the book you want:");
        String bookId = console.getInput();
        if (libraryResource.reserveBook(Integer.parseInt(bookId)))
            responseToUser("Thank You! Enjoy the book.\n");
        else
            responseToUser("Sorry we don't have that book yet.\n");
    }

    public String getUserInput() {
        return console.getInput();
    }
}
