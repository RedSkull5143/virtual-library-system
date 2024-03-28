package com.omshinde.virtuallibrarysystem.operations;

import com.omshinde.virtuallibrarysystem.isbn.ISBNChecker;
import com.omshinde.virtuallibrarysystem.models.Book;
import com.omshinde.virtuallibrarysystem.models.Library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookUploader {

    private int booksAdded = 0;
    private int booksSkipped = 0;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private ISBNChecker check ;
    private Library library;

//    private static final String filepath="src/main/resources/dataset.csv";

    public void uploadBook(String filepath) {
        try {
            processBook(filepath);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Books added: " + booksAdded);
        System.out.println("Books skipped due to duplicate ISBNs: " + booksSkipped);
    }


    public void processBook(String filepath) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 6) { // Assuming CSV format: ISBN, Title, Author
                String title = parts[0].trim();
                String author = parts[1].trim();
                String isbn = parts[2].trim();
                String genre = parts[3].trim();
                LocalDate publication_date = LocalDate.parse(parts[4].trim(), formatter);
                int noOfCopies = Integer.parseInt(parts[5].trim());

                Book book = new Book(title, author, isbn, genre, publication_date, noOfCopies);

                // Check uniqueness of ISBN
                if (check.isISBNUnique(book.getISBN(), library.books)) {
                    library.books.add(book);
                    // Add book to collection

                    System.out.println("Added book: " + book.getTitle());
                    booksAdded++;
                } else {
                    // ISBN is a duplicate
                    System.out.println("Skipped duplicate ISBN: " + book.getTitle());
                    booksSkipped++;
                }
            }
        }
    }
}
