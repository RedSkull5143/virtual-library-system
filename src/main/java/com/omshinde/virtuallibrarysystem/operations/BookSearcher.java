package com.omshinde.virtuallibrarysystem.operations;

import com.omshinde.virtuallibrarysystem.models.Book;
import com.omshinde.virtuallibrarysystem.models.Library;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BookSearcher {
    private Library library;
    private static Scanner sc=new Scanner(System.in);
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private BookLender borrow;
    private static List<Book> books;

    public BookSearcher(Library lib){
        this.library=new Library();
        this.books=lib.books;
    }



    public static void search() {

        List<Book> result = new ArrayList<>();

        System.out.println("Enter your search criteria :");
        System.out.println("1 .search by the title");
        System.out.println("2 .search by the author");
        System.out.println("3 .search by the ISBN");
        System.out.println("4 .search by genre");
        System.out.println("5 .search by Published date");
        System.out.println("6 .search by number of copies");

        int a = sc.nextInt();
        switch (a) {
            case 1:
                System.out.println("Enter the title of book :");
                String title = sc.next();
                result = searchByTitle(title, books);
                if (!result.isEmpty()) {
                    System.out.println("Books according to your search :");
                    for (Book res : result) {
                        System.out.println(res.getTitle());
                    }
                } else {
                    break;
                }
                result = addfilter(result);
                break;

            case 2:
                System.out.println("Enter the author of book :");
                String author = sc.next();
                result = searchByAuthor(author,books);
                if (!result.isEmpty()) {
                    System.out.println("Books according to your search :");
                    for (Book res : result) {
                        System.out.println(res.getTitle());
                    }
                } else {
                    break;
                }
                result = addfilter(result);
                break;

            case 3:
                System.out.println("Enter the ISBN of book :");
                String isbn = sc.next();
                result = searchByISBN(isbn,books);
                if (!result.isEmpty()) {
                    System.out.println("Books according to your search :");
                    for (Book res : result) {
                        System.out.println(res.getTitle());
                    }
                } else {
                    break;
                }
                result = addfilter(result);
                break;

            case 4:
                System.out.println("Enter genre of book :");
                String Genre = sc.next();
                result = searchByGenre(Genre,books);
                if (!result.isEmpty()) {
                    System.out.println("Books according to your search :");
                    for (Book res : result) {
                        System.out.println(res.getTitle());
                    }
                } else {
                    break;
                }
                result = addfilter(result);
                break;

            case 5:
                System.out.println("Enter the published date of book :");
                String d = sc.next();
                LocalDate date = LocalDate.parse(d, formatter);
                result = searchByDate(date,books);
                if (!result.isEmpty()) {
                    System.out.println("Books according to your search :");
                    for (Book res : result) {
                        System.out.println(res.getTitle());
                    }
                } else {
                    break;
                }
                result = addfilter(result);
                break;

            case 6:
                System.out.println("Enter the No of copies of book :");
                int noOfCopies = sc.nextInt();
                result = searchByCopies(noOfCopies,books);
                if (!result.isEmpty()) {
                    System.out.println("Books according to your search :");
                    for (Book res : result) {
                        System.out.println(res.getTitle());
                    }
                } else {
                    break;
                }
                result = addfilter(result);
                break;
            default:
                System.out.println("Invalid input");

        }

        if (result.isEmpty()) {
            System.out.println("No result found");
        } else {
            System.out.println("Books according to your search :");
            int i = 1;
            for (Book res : result) {
                System.out.println(i + "." + res.getTitle());
                i++;
            }


        }
    }


    public static List<Book> searchByTitle(String title, List<Book> books) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }


    public static List<Book> searchByAuthor(String author, List<Book> books) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public static List<Book> searchByGenre(String Genre, List<Book> books) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre().equalsIgnoreCase(Genre)) {
                result.add(book);
            }
        }
        return result;
    }

    public static List<Book> searchByISBN(String isbn, List<Book> books) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getISBN().equalsIgnoreCase(isbn)) {
                result.add(book);
            }
        }
        return result;
    }

    public static List<Book> searchByDate(LocalDate date, List<Book> books) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getPublication_Date().isEqual(date)) {
                result.add(book);
            }
        }
        return result;
    }

    public static List<Book> searchByCopies(int copies, List<Book> books) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getNoOfCopies() == copies) {
                result.add(book);
            }
        }
        return result;
    }

    public static List<Book> addfilter(List<Book> result) {
        System.out.println("Do you want to filter the result(Y/N) ?:");
        String ch = sc.next();
        while (ch.equalsIgnoreCase("y")) {
            System.out.println("Enter your search criteria :");
            System.out.println("1 .search by the title");
            System.out.println("2 .search by the author");
            System.out.println("3 .search by the ISBN");
            System.out.println("4 .search by genre");
            System.out.println("5 .search by Published date");
            System.out.println("6 .search by number of copies");

            int a = sc.nextInt();
            switch (a) {
                case 1:
                    System.out.println("Enter the title of book :");
                    String title = sc.next();
                    result = searchByTitle(title, result);
                    break;

                case 2:
                    System.out.println("Enter the author of book :");
                    String author = sc.next();
                    result = searchByAuthor(author, result);
                    break;

                case 3:
                    System.out.println("Enter the ISBN of book :");
                    String isbn = sc.next();
                    result = searchByISBN(isbn, result);
                    break;

                case 4:
                    System.out.println("Enter genre of book :");
                    String Genre = sc.next();
                    result = searchByGenre(Genre, result);
                    break;

                case 5:
                    System.out.println("Enter the published date of book :");
                    String d = sc.next();
                    LocalDate date = LocalDate.parse(d, formatter);
                    result = searchByDate(date, result);
                    break;

                case 6:
                    System.out.println("Enter the No of copies of book :");
                    int noOfCopies = sc.nextInt();
                    result = searchByCopies(noOfCopies, result);
                    break;
                default:
                    System.out.println("Invalid input");
            }

            if (!result.isEmpty()) {
                System.out.println("Books according to your search :");
                for (Book res : result) {
                    System.out.println(res.getTitle());
                }
            } else {
                return Collections.emptyList();
            }

            System.out.println("Do you want to filter the result(Y/N) :");
            ch = sc.next();


        }
        return result;


    }
}
