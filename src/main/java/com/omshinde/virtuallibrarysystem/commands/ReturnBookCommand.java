package com.omshinde.virtuallibrarysystem.commands;

import com.omshinde.virtuallibrarysystem.models.Library;

public class ReturnBookCommand implements Command {
    @Override
    public void execute(Library lib) {
        lib.returnBook();
    }
}