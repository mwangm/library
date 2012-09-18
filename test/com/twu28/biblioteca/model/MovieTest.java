package com.twu28.biblioteca.model;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MovieTest {
    @Test
    public void testToString(){
        int movieId = 1;
        String name = "my movie";
        Movie movie = new Movie(movieId, name);
        String expectResult = "ID:" + movieId + " Movie Name:" + name;
        assertThat(movie.toString(), is(expectResult));
    }
}
