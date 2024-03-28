package com.omshinde.virtuallibrarysystem;

import com.omshinde.virtuallibrarysystem.analyzers.*;
import com.omshinde.virtuallibrarysystem.isbn.ISBNChecker;
import com.omshinde.virtuallibrarysystem.models.Library;
import com.omshinde.virtuallibrarysystem.operations.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Library lib=new Library();

        boolean exit = false;
        BookSearcher searcher = new BookSearcher(lib);


        System.out.println("📕📗📘📙📔📕📗📘📙📔📕📗📘📙📔📕📗📘📙📔📕📗📘📙📔📕📗📘📙📔📗📘");
        System.out.println("📚          Virtual Library Management System (VLS)        📚`");

        while (!exit) {
            System.out.println("📕📗📘📙📔📕📗📘📙📔📕📗📘📙📔📕📗📘📙📔📕📗📘📙📔📕📗📘📙📔📗📘");
            System.out.println("1. Search for a book            \t2. 🚚 Borrow a book");
            System.out.println("3. Return a book                \t4. 📫 View Library Inventory");
            System.out.println("5. 💾 View Transaction Log      \t6. 👆 Upload Books");
            System.out.println("7. Books Statistics Overview    \t8. Analyzers");
            System.out.println("9. Exit");
            System.out.println("------------------------------------------------------------------");
            System.out.print("Choose an option: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            System.out.println("------------------------------------------------------------------");

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
                    ISBNChecker isbnChecker = new ISBNChecker();
                    System.out.println("Enter the file path of the CSV containing book data: ");
//                    String filePath = scanner.nextLine();
                    BookUploader bookUploader = new BookUploader(isbnChecker, lib);
                    bookUploader.uploadBook("src/main/resources/dataset.csv");
                    break;
                case 7:
                    // Books Statistics Overview
                    while (true) {
                        System.out.println("\nBooks Statistics Overview:");
                        System.out.println("1. Show All Books ");
                        System.out.println("2. Total No. of Books Present");
                        System.out.println("3. Number of currently borrowed books");
                        System.out.println("4. List of titles of all borrowed books");
                        System.out.println("5. Back to Main Menu");
                        System.out.print("Choose an option: ");
                        int statsChoice = scanner.nextInt();

                        switch (statsChoice) {
                            case 1:
                                BookStatisticsCalculator.displayLibraryStatistics(lib);
                                break;
                            case 2:
                                System.out.println("Total number of books present: " + BookStatisticsCalculator.getTotalBooks(lib.books));
                                break;
                            case 3:
                                System.out.println("Number of currently borrowed books: " + BookStatisticsCalculator.calculateCurrentlyBorrowedBooksCount(lib.log));
                                break;
                            case 4:
                                System.out.println("List of titles of all borrowed books:");
                                List<String> borrowedTitles = BookStatisticsCalculator.getAllBorrowedBookTitles(lib.log,lib.books);
                                for (String title : borrowedTitles) {
                                    System.out.println(title);
                                }
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Invalid selection. Please try again.");
                                break;
                        }

                        if (statsChoice == 5)
                            break;
                    }
                    break;
                case 8:
                    // Analyzers
                    while (true) {
                        System.out.println("\nAnalyzers:");
                        System.out.println("1. Analyze Borrowing Trends per Month");
                        System.out.println("2. Analyze Borrowing Trends per Quarter");
                        System.out.println("3. Analyze Borrowing Trends per Year");
                        System.out.println("4. Analyze Trending Genres");
                        System.out.println("5. Analyze Trending Authors");
                        System.out.println("6. Analyze Most Popular Book");
                        System.out.println("7. Back to Main Menu");
                        System.out.print("Choose an option: ");
                        int analyzerChoice = scanner.nextInt();

                        switch (analyzerChoice) {
                            case 1:
                                BorrowingTrendAnalyzer.analyzeBorrowingTrendsPerMonth(lib);
                                break;
                            case 2:
                                BorrowingTrendAnalyzer.analyzeBorrowingTrendsPerQuarter(lib);
                                break;
                            case 3:
                                System.out.println("Enter the year to analyze : ");
                                int year=scanner.nextInt();
                                BorrowingTrendAnalyzer.analyzeBorrowingTrendsPerYear(lib, year);
                                break;
                            case 4:
                                GenreTrendAnalyzer.analyzeGenreTrends(lib, lib.getLog());
                                break;
                            case 5:
                                PopularAuthorAnalyzer.analyzeAuthorTrends(lib, lib.getLog());
                                break;
                            case 6:
                                System.out.println("Display Top - ");
                                int limit = scanner.nextInt();
                                MostBorrowedBooksAnalyzer.analyzeMostBorrowedBooks(lib, limit);
                                break;
                            case 7:
                                break;
                            default:
                                System.out.println("Invalid selection. Please try again.");
                                break;
                        }

                        if (analyzerChoice == 7)
                            break;
                    }
                    break;
                case 9:
                    // Exit
                    System.out.println("📕📗📘📙📔📕📗📘📙📔📕📗📘📙📔📕📗📘📙📔📕📗📘📙📔");
                    System.out.println("📔\tThank You for Visitng. Come Back Soon😊  📕");
                    System.out.println("📕📗📘📙📔📕📗📘📙📔📕📗📘📙📔📕📗📘📙📔📕📗📘📙📔");
                    exit = true;
            }}}}

