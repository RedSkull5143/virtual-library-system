package com.omshinde.virtuallibrarysystem.models;
import com.omshinde.virtuallibrarysystem.isbn.ISBNChecker;
import java.util.ArrayList;
import java.util.List;

public class Library {

    public  List<Book> books = new ArrayList<>();
    private ISBNChecker check = new ISBNChecker();
    public List<TransactionLog> log = new ArrayList<>();

    public Library() {
        this.books = new ArrayList<>();
        this.check = new ISBNChecker();
    }


    // add book
    public void add(Book book) {
        boolean isbnUnique = check.isISBNUnique(book.getISBN(), books);
        if (isbnUnique) {
            books.add(book);
        }
    }

    //-------------------------------------------------------------------------------------------------


    public void showStatus(Book bk) {

        System.out.println("Here is the details of the book: \nTitle : " + bk.getTitle() + "\n"
                + "Author : " + bk.getAuthor() + "\n" + "ISBN : " + bk.getISBN() + "\n"
                + "Genre : " + bk.getGenre() + "\n"
                + "Publication date : " + bk.getPublication_Date());
        if (bk.getNoOfCopies() < 1) {
            bk.setStatus("Out of stock");
            System.out.println("Current availability status : " + bk.getStatus());
        } else {
            bk.setStatus("Available");
            System.out.println("Current availability status : " + bk.getStatus());
        }
    }


    //-----------------------------------------------------------------------------------------------

    public void viewLog() {
        if(books.isEmpty()){
            System.err.println("Inventory is Empty. No logs present!");
        }else{
        for (TransactionLog lg : log) {
            String status = (lg.getReturned().equalsIgnoreCase("Yes") ? "Returned" : "Borrowed");
            System.out.println("UserID : " + lg.getUserId() + ", ISBN : " + lg.getISBN() + ", Status: " + status + ", Borrow Date : " + lg.getBorrowDate() + ", Return Date : " + lg.getReturnDate());
        }
    }}

    //----------------------------------------------------------------------------------------------------


    public void bookInventory() {
        if(books.isEmpty()){
            System.err.println("Inventory is Empty. Add Books");
        }else{
        for (Book bk : books) {
            System.out.println("Title : " + bk.getTitle() +" , "+ "No of copies : " + bk.getNoOfCopies());
        }}
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<TransactionLog> getLog() {
        return log;
    }

}
