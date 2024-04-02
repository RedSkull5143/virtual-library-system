package com.omshinde.virtuallibrarysystem.commands;

import com.omshinde.virtuallibrarysystem.models.Library;

public class UploadBookCommand implements Command{
    @Override
    public void execute(Library lib){
        lib.UploadBook("src/main/resources/dataset.csv");
    }
}
