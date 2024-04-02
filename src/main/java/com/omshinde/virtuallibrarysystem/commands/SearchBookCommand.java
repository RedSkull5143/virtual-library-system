package com.omshinde.virtuallibrarysystem.commands;

import com.omshinde.virtuallibrarysystem.models.Library;

public class SearchBookCommand implements Command {
    @Override
    public void execute(Library lib) {
        lib.searchBook();
    }
}
