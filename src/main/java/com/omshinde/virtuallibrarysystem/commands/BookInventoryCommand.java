package com.omshinde.virtuallibrarysystem.commands;

import com.omshinde.virtuallibrarysystem.models.Library;

public class BookInventoryCommand implements Command {
    @Override
    public void execute(Library lib) {
        lib.bookInventory();
    }
}