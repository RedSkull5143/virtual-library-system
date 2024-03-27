package com.omshinde.virtuallibrarysystem;

import com.omshinde.virtuallibrarysystem.models.Book;
import com.omshinde.virtuallibrarysystem.models.Library;
import com.omshinde.virtuallibrarysystem.operations.*;

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
            System.out.println("8. Exit");
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
                    BookUploader bookUploader = new BookUploader();
                    System.out.println("Enter the file path of the CSV containing book data: ");
                    String filePath = scanner.nextLine().trim();
                    bookUploader.uploadBook(filePath);
                    break;
                case 7:
                    BookStatisticsCalculator.displayLibraryStatistics(lib);
                    break;
                case 8:
                    // Exit
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        }
    }

    }

