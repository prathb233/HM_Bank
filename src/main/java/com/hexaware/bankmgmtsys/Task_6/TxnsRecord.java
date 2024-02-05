package com.hexaware.bankmgmtsys.Task_6;

import java.util.ArrayList;
import java.util.Scanner;

public class TxnsRecord {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> transactions = new ArrayList<>();

        System.out.println("Welcome to HM Bank!");

        boolean continueTransactions = true;

        while (continueTransactions) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.print("3. Exit \n=> ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    transactions.add(depositAmount + "  -- Credit");
                    System.out.println("Deposit successful!");
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    transactions.add(withdrawalAmount + "  -- Debit"); // Using subtraction sign to represent withdrawal
                    System.out.println("Withdrawal successful!");
                    break;

                case 3:
                    continueTransactions = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        // Display transaction history
        System.out.println("\nTransaction History:");
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println("Transaction " + (i + 1) + ": " + transactions.get(i));
        }

        scanner.close();
    }
}

