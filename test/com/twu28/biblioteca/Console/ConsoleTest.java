package com.twu28.biblioteca.console;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConsoleTest {
    public static final String HELLO = "hello";
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setIn(new ByteArrayInputStream(HELLO.getBytes()));
    }

    @Test
    public void testOutput() {
        System.out.print(HELLO);
        assertThat(HELLO, is(outContent.toString()));
    }

    @Test
    public void testInput() throws Exception {
        Scanner scanner = new Scanner(System.in);
        assertThat(scanner.nextLine(), is(HELLO));
    }

    @After
    public void cleanUpStreams() {
        System.setIn(System.in);
        System.setOut(System.out);
    }
}
