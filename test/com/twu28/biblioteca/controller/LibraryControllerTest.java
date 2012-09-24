package com.twu28.biblioteca.controller;

import com.twu28.biblioteca.console.ConsoleStub;
import com.twu28.biblioteca.service.LibraryService;
import com.twu28.biblioteca.service.LoginService;
import com.twu28.biblioteca.model.Book;
import com.twu28.biblioteca.model.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class LibraryControllerTest {

    public static final String USER_NAME = "UserName";
    public static final String USER_PASSWORD = "UserPassword";
    public static final String INVALID_PASSWORD = "invalidPassword";
    private ConsoleStub console;
    private LibraryController libraryController;

    @Before
    public void setUp() throws Exception {
        console = new ConsoleStub();
        libraryController = new LibraryController(console, createLibraryResource(), createLoginService());
    }

    @Test
    public void should_be_able_get_user_input(){
        console.input("1");
        assertThat( Integer.parseInt(libraryController.getUserInput()), is(1));
    }

    @Test
    public void should_be_able_to_display_welcome_message(){
        libraryController.showWelcome();
        assertThat(console.getOutput(), is("Welcome to use the public library system"));
    }

    @Test
    public void should_be_able_to_display_menu_message() {
        libraryController.displayMenu();
        assertThat(console.getOutput(), is("1:View all books\n2:Reserve a book\n3:Check Your Library Number\n5:show all movie\n6:login\n0:exit\nselect a option to go continued:"));
    }

    @Test
    public void should_show_all_books_when_User_select_to_view_all_books(){
        libraryController.playActions(1);
        assertThat(console.getOutput(), is("ID:1234 Name:the JavaScript\n"));
    }

    @Test
    public void should_reserve_successful_when_User_select_an_exit_book(){
        console.input("1234");
        libraryController.playActions(2);
        assertThat(console.getOutput(), is("please enter the id of the book you want:Thank You! Enjoy the book.\n"));
    }

    @Test
    public void should_reserve_unsuccessful_when_User_select_an_none_exit_book() {
        console.input("1111");
        libraryController.playActions(2);
        assertThat(console.getOutput(), is("please enter the id of the book you want:Sorry we don't have that book yet.\n"));
    }

    @Test
    public void should_be_able_to_check_details() {
        boolean continued = libraryController.playActions(3);
        assertThat(console.getOutput(), is("Please talk to Librarian. Thank you\n"));
        assertThat(continued, is(true));
    }

    @Test
    public void should_show_all_movies_when_User_select_to_view_all_movies(){
        libraryController.playActions(5);
        assertThat(console.getOutput(), is("ID:1 Movie Name:I am sam\n"));
    }

    @Test
    public void should_remind_not_a_valid_option_when_not_avaliable_option(){
        libraryController.playActions(7);
        assertThat(console.getOutput(), is("please select a valid option!\n"));
    }

    @Test
    public void should_be_able_to_exit() {
        boolean continued = libraryController.playActions(0);

        assertThat(console.getOutput(), is("bye~\n"));
        assertThat(continued, is(false));

    }

    @Test
    public void should_be_able_to_login_with_valid_info() {
        console.input(USER_NAME);
        console.input(USER_PASSWORD);

        libraryController.playActions(6);
        assertThat(console.getOutput(), is("please enter you library user id:please enter you password:log in successful\n"));

    }

    @Test
    public void should_be_failed_to_login_with_invalid_info() {
        console.input(USER_NAME);
        console.input(INVALID_PASSWORD);

        libraryController.playActions(6);
        assertThat(console.getOutput(), is("please enter you library user id:please enter you password:invalid id or password\n"));

    }

    private LoginService createLoginService() {
        LoginService loginService = mock(LoginService.class);
        when(loginService.login(USER_NAME, USER_PASSWORD)).thenReturn(true);
        when(loginService.login(USER_NAME, INVALID_PASSWORD)).thenReturn(false);
        return loginService;
    }

    private LibraryService createLibraryResource() {
        LibraryService libraryService = mock(LibraryService.class);
        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1234, "the JavaScript"));
        List<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie(1, "I am sam"));
        when(libraryService.reserveBook(1234)).thenReturn(true);
        when(libraryService.reserveBook(1111)).thenReturn(false);
        when(libraryService.getAllBooks()).thenReturn(books);
        when(libraryService.getAllMovies()).thenReturn(movies);
        return libraryService;
    }

}
