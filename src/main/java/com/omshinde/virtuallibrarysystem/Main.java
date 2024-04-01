package com.omshinde.virtuallibrarysystem;

import com.omshinde.virtuallibrarysystem.models.Library;
import com.omshinde.virtuallibrarysystem.operations.BookSearcher;
import com.omshinde.virtuallibrarysystem.utlis.ScannerUtils;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        BookSearcher searcher = new BookSearcher(lib);

        boolean exit = false;

        displayWelcomeMessage();

        while (!exit) {
            showMainMenu();
            int choice = ScannerUtils.getIntInput("Choose an option: ");

            switch (choice) {
                case 1:
                    lib.searchBook();
                    break;
                case 2:
                    lib.borrowBook();
                    break;
                case 3:
                    lib.returnBook();
                    break;
                case 4:
                    lib.bookInventory();
                    break;
                case 5:
                    lib.viewLog();
                    break;
                case 6:
                    lib.UploadBook("src/main/resources/dataset.csv");
                    break;
                case 7:
                    lib.showStatistics();
                    break;
                case 8:
                    lib.analyzer();
                    break;
                case 9:
                    displayExitMessage();
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 9.");
            }
        }
    }

    private static void displayWelcomeMessage() {
        System.out.println("📕📗📘📙📔📕📗📘📙📔📕📗📘📙📔📕📗📘📙📔📕📗📘📙📔📕📗📘📙📔");
        System.out.println("📚          Virtual Library Management System (VLS)        📚");
    }

    private static void showMainMenu() {
        System.out.println("📕📗📘📙📔📕📗📘📙📔📕📗📘📙📔📕📗📘📙📔📕📗📘📙📔📕📗📘📙📔📕📗📘");
        displayMainMenuOptions();
        System.out.println("------------------------------------------------------------------");
    }

    private static void displayMainMenuOptions() {
        System.out.println("1. Search for a book            \t2. 🚚 Borrow a book");
        System.out.println("3. Return a book                \t4. 📫 View Library Inventory");
        System.out.println("5. 💾 View Transaction Log      \t6. 👆 Upload Books");
        System.out.println("7. Books Statistics Overview    \t8. Analyzers");
        System.out.println("9. Exit");
    }

    private static void displayExitMessage() {
        System.out.println("📕📗📘📙📔📕📗📘📙📔📕📗📘📙📔📕📗📘📙📔📕📗📘📙📔");
        System.out.println("📔\tThank You for Visitng. Come Back Soon😊  📕");
        System.out.println("📕📗📘📙📔📕📗📘📙📔📕📗📘📙📔📕📗📘📙📔📕📗📘📙📔");
    }
}
