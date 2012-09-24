package com.twu28.biblioteca.controller;

import com.twu28.biblioteca.Console.ConsoleStub;
import com.twu28.biblioteca.model.Book;
import com.twu28.biblioteca.model.LibraryResource;
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

    private ConsoleStub console;
    private LibraryController libraryController;

    @Before
    public void setUp() throws Exception {
        console = new ConsoleStub();
        libraryController = new LibraryController(console, createLibraryResource(), null);
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
        assertThat(console.getOutput(), is("1:View all books\n2:Reserve a book\n3:Check Your Library Number\n4:show menu again\n5:show all movie\n6:login\n0:exit\nselect a option to go continued:"));
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
        libraryController.setLoginService(mock(LoginService.class));
        boolean continued = libraryController.playActions(0);
        
        assertThat(console.getOutput(), is("bye~\n"));
        assertThat(continued, is(false));

    }

    @Test
    public void should_be_able_to_login_with_valid_info() {
        String userId = "123";
        String password = "666666";
        libraryController.setLoginService(createLoginService(userId, password, false));

        console.input(userId);
        console.input(password);

        libraryController.playActions(6);
        assertThat(console.getOutput(), is("please enter you library user id:please enter you password:invalid id or password\n"));

    }

    @Test
    public void should_be_failed_to_login_with_invalid_info() {
        String userId = "123";
        String password = "666666";
        libraryController.setLoginService(createLoginService(userId,password, true));

        console.input(userId);
        console.input(password);

        libraryController.playActions(6);
        assertThat(console.getOutput(), is("please enter you library user id:please enter you password:log in successful\n"));

    }


    private LoginService createLoginService(String userId, String password, boolean loginSuccess) {
        LoginService loginService = mock(LoginService.class);
        when(loginService.login(userId, password)).thenReturn(loginSuccess);
        return loginService;
    }



    private LibraryResource createLibraryResource() {
        LibraryResource libraryResource = mock(LibraryResource.class);
        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1234, "the JavaScript"));
        List<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie(1, "I am sam"));
        when(libraryResource.reserveBook(1234)).thenReturn(true);
        when(libraryResource.reserveBook(1111)).thenReturn(false);
        when(libraryResource.getAllBooks()).thenReturn(books);
        when(libraryResource.getAllMovies()).thenReturn(movies);
        return libraryResource;
    }

}
