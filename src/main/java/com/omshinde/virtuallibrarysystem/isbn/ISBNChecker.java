package com.omshinde.virtuallibrarysystem.isbn;

import com.omshinde.virtuallibrarysystem.models.Book;

import java.util.List;

public class ISBNChecker {

    public boolean isISBNUnique(String newISBN,List<Book> books) {
        for (Book book : books) {
            if (book.getISBN().equals(newISBN)) {
                return false; // ISBN is not unique
            }
        }
        return true; // ISBN is unique
    }

}
