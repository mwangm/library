package com.twu28.biblioteca;

import com.twu28.biblioteca.Console.Console;
import com.twu28.biblioteca.Service.LibraryService;
import com.twu28.biblioteca.Service.LoginService;
import com.twu28.biblioteca.controller.LibraryController;

public class libraryApp {

    public static void main(String[] args) {
        LibraryController libraryController = new LibraryController(new Console(), new LibraryService(), new LoginService());

        libraryController.showWelcome();
        libraryController.displayMenu();

        while (continueView(libraryController)) ;
    }

    private static boolean continueView(LibraryController libraryController) {
        Integer selectedOption = Integer.valueOf(libraryController.getUserInput());
        return libraryController.playActions(selectedOption);
    }
}
