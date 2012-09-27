package com.twu28.biblioteca.action;

import com.twu28.biblioteca.controller.LibraryController;

public interface IAction {
    public void  playAction(LibraryController libraryController);
    public int  getActionCode();
    public String getDescription();
}
