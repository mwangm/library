package com.twu28.biblioteca.action;

public class ActionFactory {
    public static IAction createAction(int selectedOption) {
        switch (selectedOption) {
            case 1:
                return new ShowBooksAction();
            case 2:
                return new ReserveBookAction();
            case 3:
                return new CheckDetailAction();
            case 5:
                return new ShowMoviesAction();
            case 6:
                return new LoginAction();
            case 0:
                return new ExitAction();
            default:
                return new NotValidOption();
        }
    }
}
