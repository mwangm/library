package com.twu28.biblioteca.Console;

import java.util.ArrayList;

public class ConsoleStub implements IConsole {
    private ArrayList<String> consoleOutput = new ArrayList<String>();
    private ArrayList<String> consoleInput = new ArrayList<String>();

    public String getOutput() {
        StringBuilder contentData = new StringBuilder();
        for (String line : consoleOutput) {
            contentData.append(line);
        }
        return contentData.toString();
    }

    @Override
    public void output(String message) {
        consoleOutput.add(message);
    }

    @Override
    public String getInput() {
        return consoleInput.remove(0);
    }

    public void input(String input) {
        this.consoleInput.add(input);
    }
}
