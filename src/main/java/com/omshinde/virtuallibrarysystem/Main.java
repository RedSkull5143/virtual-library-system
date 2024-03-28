package com.omshinde.virtuallibrarysystem;

import com.omshinde.virtuallibrarysystem.analyzers.MostBorrowedBooksAnalyzer;
import com.omshinde.virtuallibrarysystem.analyzers.PopularAuthorAnalyzer;
import com.omshinde.virtuallibrarysystem.analyzers.BorrowingTrendAnalyzer;
import com.omshinde.virtuallibrarysystem.analyzers.GenreTrendAnalyzer;
import com.omshinde.virtuallibrarysystem.models.Book;
import com.omshinde.virtuallibrarysystem.models.Library;
import com.omshinde.virtuallibrarysystem.operations.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Book book=new Book("Naruto Uzumaki","Jiraya","123","inspiration",90);
        Book book1=new Book("Sasuke Uchiha","Sharingan","13","motivation",90);
        Book book2=new Book("Trash","Tsunade","125","reality",110);
        Book book3=new Book("Madara Uchiha","Ghost","213","dreams",90);
        Book book4=new Book("Minato Namikaze","Jiraya","1396","truth",1);

        Library lib=new Library();
        lib.add(book);
        lib.add(book1);
        lib.add(book2);
        lib.add(book3);
        lib.add(book4);

        boolean exit = false;

        while (!exit) {
            System.out.println("Main Menu:");
            System.out.println("1. Search for a book");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. View Library Inventory");
            System.out.println("5. View Transaction Log");
            System.out.println("6. Upload Books");
            System.out.println("7. Books Stastics Overview");
            System.out.println("8. Total No. of Books Present ");
            System.out.println("9. Exit");
            System.out.println("10. Number of currently borrowed books");
            System.out.println("11. List of titles of all borrowed books");
            System.out.println("12. Analyze Borrowing Trends per Month ");
            System.out.println("13. View Trending Genres");
            System.out.println("14. View Trending Authors ");
            System.out.println("15. Most Popular Book");
            System.out.print("Choose an option: ");
            Scanner scanner=new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Search for a book
                    BookSearcher.search();
                    break;
                case 2:
                    // Borrow a book
                    BookLender bookLender = new BookLender(lib);
                    bookLender.borrowByISBN();
                    break;
                case 3:
                    // Return a book
                    BookReturner bookReturner = new BookReturner(lib);
                    bookReturner.ReturnBook();
                    break;
                case 4:
                    // View Library Inventory
                    lib.bookInventory();
                    break;
                case 5:
                    // View Transaction Log
                    lib.viewLog();
                    break;
                case 6:
                    // Upload Books
                    System.out.println("Enter the file path of the CSV containing book data: ");
                    String filePath = scanner.nextLine().trim();
                    BookUploader bookUploader = new BookUploader();
                    bookUploader.uploadBook(filePath);
                    break;
                case 7:
                    // Display Library Status
                    BookStatisticsCalculator.displayLibraryStatistics(lib);
                    break;
                case 8:
                    // Display Total No. of Books
                    System.out.println(BookStatisticsCalculator.getTotalBooks(lib.books));
                    break;
                case 9:
                    // Exit
                    exit = true;
                    break;
                case 10:
                    // Display No. of Current Borrowed Books
                    System.out.println("Number of currently borrowed books: " + BookStatisticsCalculator.calculateCurrentlyBorrowedBooksCount());
                    break;
                case 11:
                    // Dispaly Titles of Borrowed Books
                    System.out.println("List of titles of all borrowed books:");
                    List<String> borrowedTitles = BookStatisticsCalculator.getAllBorrowedBookTitles();
                    for (String title : borrowedTitles) {
                        System.out.println(title);
                    }
                    break;
                case 12:
                    // Display Borrowing Trends PerMonth, PerQuarter, PerYear
                    BorrowingTrendAnalyzer.analyzeBorrowingTrendsPerMonth(lib);
                    BorrowingTrendAnalyzer.analyzeBorrowingTrendsPerQuarter(lib);
                    BorrowingTrendAnalyzer.analyzeBorrowingTrendsPerYear(lib,2024);
                    break;
                case 13:
                    // Display Trends in Genre
                    GenreTrendAnalyzer.analyzeGenreTrends(lib, lib.getLog());
                    break;
                case 14:
                    // Display Popular Authors
                    PopularAuthorAnalyzer.analyzeAuthorTrends(lib,lib.getLog());
                    break;
                case 15:
                    // Display High Grossing Books
                    System.out.println("Display Top - ");
                    int limit=scanner.nextInt();
                    MostBorrowedBooksAnalyzer.analyzeMostBorrowedBooks(lib,limit);
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        }
    }

    }

