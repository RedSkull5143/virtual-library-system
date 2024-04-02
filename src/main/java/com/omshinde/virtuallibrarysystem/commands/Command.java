package com.omshinde.virtuallibrarysystem.commands;

import com.omshinde.virtuallibrarysystem.models.Library;

public interface Command {
    void execute(Library lib);
}
