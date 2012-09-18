package com.twu28.biblioteca.model;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BookTest {

    @Test
    public void should_be_able_to_string_with_specific_format(){
        int bookId = 1;
        String name = "my book";
        Book book = new Book(bookId, name);
        String expectResult = "ID:" + bookId + " Name:" + name;
        assertThat(book.toString(), is(expectResult));
    }
}
