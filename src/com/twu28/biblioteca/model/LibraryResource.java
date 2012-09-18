package com.twu28.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class LibraryResource {
    private List<Book> books;
    private List<Movie> movies;

    public LibraryResource() {
        initialBookList();
        initialMovieList();
    }

    private void initialBookList() {
        books = new ArrayList<Book>();
        books.add(new Book(1, "melody"));
        books.add(new Book(2, "the design pattern"));
        books.add(new Book(3, "JavaScript:The good part"));
        books.add(new Book(4, "head first design pattern"));
        books.add(new Book(5, "design thinking"));
    }

    private void initialMovieList() {
        movies = new ArrayList<Movie>();
        movies.add(new Movie(1, "I am Sam"));
        movies.add(new Movie(2, "Thelma & Louise"));
        movies.add(new Movie(3, "La leggenda del pianista sull'oceano"));
        movies.add(new Movie(4, "Les choristes"));
    }


    public List<Book> getAllBooks() {
        return books;
    }

    public boolean reserveBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                return true;
            }
        }
        return false;
    }

    public List<Movie> getAllMovies() {
        return movies;
    }
}
