package com.twu28.biblioteca.model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LibraryResourceTest {
    private LibraryResource libraryResource;

    @Before
    public void setUp() {
        libraryResource = new LibraryResource();
    }

    @Test
    public void should_initial_all_books() {
        List<Book> bookList = libraryResource.getAllBooks();
        assertThat(bookList.size(), is(5));
        assertThat(bookList.get(0).getId(), is(1));
        assertThat(bookList.get(2).getName(), is("JavaScript:The good part"));
    }

    @Test
    public void should_initial_all_movies() {
        List<Movie> allMovies = libraryResource.getAllMovies();
        assertThat(allMovies.size(), is(4));
        assertThat(allMovies.get(0).getId(), is(1));
        assertThat(allMovies.get(1).getName(), is("Thelma & Louise"));
    }

    @Test
    public void should_success_when_reserve_book_exist() {
        assertThat(libraryResource.reserveBook(1), is(true));
    }

    @Test
    public void should_success_when_reserve_book_not_exist() {
        assertThat(libraryResource.reserveBook(10), is(false));
    }

}
