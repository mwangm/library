package com.twu28.biblioteca.Console;

import java.util.Scanner;

public class Console implements IConsole {

    @Override
    public void output(String message) {
        System.out.println(message);
    }

    @Override
    public String getInput(){
        String input = null;
        try{
            input = new Scanner(System.in).nextLine();
        }
        catch (Exception e){
            System.out.println("read error !");
        }
        return input;
    }
}
