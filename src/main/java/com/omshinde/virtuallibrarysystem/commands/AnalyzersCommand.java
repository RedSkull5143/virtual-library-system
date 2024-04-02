package com.omshinde.virtuallibrarysystem.commands;

import com.omshinde.virtuallibrarysystem.models.Library;

public class AnalyzersCommand implements Command{
    @Override
    public void execute(Library lib){
        lib.analyzer();
    }
}
