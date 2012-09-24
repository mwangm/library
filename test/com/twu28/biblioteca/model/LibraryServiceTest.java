package com.twu28.biblioteca.model;

import com.twu28.biblioteca.Service.LibraryService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LibraryServiceTest {
    private LibraryService libraryService;

    @Before
    public void setUp() {
        libraryService = new LibraryService();
    }

    @Test
    public void should_initial_all_books() {
        List<Book> bookList = libraryService.getAllBooks();
        assertThat(bookList.size(), is(5));
        assertThat(bookList.get(0).getId(), is(1));
        assertThat(bookList.get(2).getName(), is("JavaScript:The good part"));
    }

    @Test
    public void should_initial_all_movies() {
        List<Movie> allMovies = libraryService.getAllMovies();
        assertThat(allMovies.size(), is(4));
        assertThat(allMovies.get(0).getId(), is(1));
        assertThat(allMovies.get(1).getName(), is("Thelma & Louise"));
    }

    @Test
    public void should_success_when_reserve_book_exist() {
        assertThat(libraryService.reserveBook(1), is(true));
    }

    @Test
    public void should_success_when_reserve_book_not_exist() {
        assertThat(libraryService.reserveBook(10), is(false));
    }

}
