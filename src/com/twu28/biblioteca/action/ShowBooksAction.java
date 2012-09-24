package com.twu28.biblioteca.action;

import com.twu28.biblioteca.controller.LibraryController;
import com.twu28.biblioteca.model.Book;

import java.util.List;

public class ShowBooksAction implements IAction{

    @Override
    public void playAction(LibraryController libraryController) {
        List<Book> allBooks = libraryController.getAllBooks();
        StringBuilder booklist = new StringBuilder();
        for (Book book : allBooks) {
            booklist.append(book.toString()).append("\n");
        }
        libraryController.responseToUser(booklist.toString());
    }

}
