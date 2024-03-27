package com.omshinde.virtuallibrarysystem.operations;

import com.omshinde.virtuallibrarysystem.models.Library;
import com.omshinde.virtuallibrarysystem.models.TransactionLog;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class BorrowingTrendAnalyzer {

    public static void analyzeBorrowingTrendsPerMonth(Library library) {
        List<TransactionLog> transactionLogs = library.getLog();

        if (transactionLogs.isEmpty()) {
            System.out.println("No transaction logs found. Cannot analyze borrowing trends.");
            return;
        }

        // Get the current year
        int currentYear = LocalDate.now().getYear();

        // Initialize an array to store borrowing counts for each month
        int[] borrowingCounts = new int[12];

        // Loop through transaction logs and count borrowings for each month
        for (TransactionLog log : transactionLogs) {
            if (log.getReturned().equalsIgnoreCase("No")) {
                LocalDate borrowDate = log.getBorrowDate();
                if (borrowDate.getYear() == currentYear) {
                    int monthIndex = borrowDate.getMonthValue() - 1; // Month index starts from 0
                    borrowingCounts[monthIndex]++;
                }
            }
        }

        // Print borrowing trends for each month
        System.out.println("Borrowing Trends per Month:");
        for (int i = 0; i < 12; i++) {
            Month month = Month.of(i + 1);
            int borrowingCount = borrowingCounts[i];
            System.out.println(month.toString() + ": " + borrowingCount + " books borrowed");
        }
    }
}
