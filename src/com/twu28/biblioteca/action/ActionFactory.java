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
                return new NotValidAction();
        }
    }
    
    public static String getActionList(){
        return "1:View all books\n2:Reserve a book\n3:Check Your Library Number\n5:show all movie\n6:login\n0:exit\nselect a option to go continued:";
    }
}
