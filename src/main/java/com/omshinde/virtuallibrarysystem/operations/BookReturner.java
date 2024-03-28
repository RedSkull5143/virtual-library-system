package com.omshinde.virtuallibrarysystem.operations;

import com.omshinde.virtuallibrarysystem.analyzers.PopularAuthorAnalyzer;
import com.omshinde.virtuallibrarysystem.analyzers.GenreTrendAnalyzer;
import com.omshinde.virtuallibrarysystem.models.TransactionLog;
import com.omshinde.virtuallibrarysystem.models.Book;
import com.omshinde.virtuallibrarysystem.models.Library;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class BookReturner {


    private final Library library;
    List<TransactionLog> log;
    List<Book> books;
    Scanner sc = new Scanner(System.in);

    public BookReturner(Library lib) {
        this.library = lib;
        this.log = lib.log;
        this.books = lib.books;
    }

    public void ReturnBook() {
        System.out.println("Enter your UserID to return the book: ");
        int UserID = sc.nextInt();
        System.out.println("Enter ISBN of the Book you want to return: ");
        String isbn = sc.next();

        boolean flag = false;
        for (TransactionLog l : log) {
            if (l.getUserId() == UserID && l.getISBN().equalsIgnoreCase(isbn)) {

                for (Book bk : books) {

                    if (bk.getISBN().equalsIgnoreCase(isbn)) {
                        System.out.println("The book you want to return is : " + bk.getTitle());
                        System.out.println("Confirm to proceed(Y/N) :");
                        String c = sc.next();
                        if (c.equalsIgnoreCase("y")) {
                            bk.setNoOfCopies(bk.getNoOfCopies() + 1);
                            if(bk.getStatus().equalsIgnoreCase("out of stock")){
                                bk.setStatus("Available");
                            }
                            l.setReturned("Yes");
                            l.setReturnDate(LocalDate.now());
                            GenreTrendAnalyzer.analyzeGenreTrends(library, library.getLog());
                            PopularAuthorAnalyzer.analyzeAuthorTrends(library,library.getLog());
                            flag = true;

                        } else {
                            System.out.println("Thank You");
                            System.exit(0);
                        }
                    }
                }

            }
            if (flag) {
                System.out.println("Book returned succesfully");


            } else {
                System.out.println("No log record Exists");
            }
        }

    }

}
