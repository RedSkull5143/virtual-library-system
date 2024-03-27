package com.omshinde.virtuallibrarysystem.operations;

import com.omshinde.virtuallibrarysystem.models.Book;
import com.omshinde.virtuallibrarysystem.models.Library;
import com.omshinde.virtuallibrarysystem.models.TransactionLog;

import java.util.ArrayList;
import java.util.List;

public class BookStatisticsCalculator {
    private static Library library;

//    public BookStatisticsCalculator(Library library) {
//        this.library = library;
//    }

    public static int getTotalBooks(List<Book> books) {
        return books.size();
    }

    public static int getAvailableBooks(List<Book> books) {
        int count = 0;
        for (Book book : books) {
            if (book.getNoOfCopies() > 0) {
                count++;
            }
        }
        return count;
    }

    public static int getOutOfStockBooks(List<Book> books) {
        int count = 0;
        for (Book book : books) {
            if (book.getNoOfCopies() == 0) {
                count++;
            }
        }
        return count;
    }

    public static int getBorrowedBooks(List<TransactionLog> logs) {
        int count = 0;
        for (TransactionLog log : logs) {
            if (log.getReturned().equalsIgnoreCase("No")) {
                count++;
            }
        }
        return count;
    }

    public static void displayLibraryStatistics(Library lib) {
        System.out.println("Library Statistics Overview:");
        System.out.println("Total Books: " + getTotalBooks(lib.books));
        System.out.println("Available Books: " + getAvailableBooks(lib.books));
        System.out.println("Borrowed Books: " + getBorrowedBooks(lib.log));
        System.out.println("Out of Stock Books: " + getOutOfStockBooks(lib.books));
    }

    public static int calculateCurrentlyBorrowedBooksCount() {
        int count = 0;
        for (TransactionLog logEntry : library.log) {
            if (logEntry.getReturned().equalsIgnoreCase("No")) {
                count++;
            }
        }
        return count;
    }

    public static List<String> getAllBorrowedBookTitles() {
        List<String> borrowedTitles = new ArrayList<>();
        boolean booksBorrowed = false;
        for (TransactionLog logEntry : library.log) {
            if (logEntry.getReturned().equalsIgnoreCase("No")) {
                booksBorrowed = true;
                for (Book book : library.books) {
                    if (book.getISBN().equals(logEntry.getISBN())) {
                        borrowedTitles.add(book.getTitle());
                        break;
                    }
                }
            }
        }
        if (!booksBorrowed) {
            System.out.println("No books are currently borrowed.");
        }
        return borrowedTitles;
    }
}
