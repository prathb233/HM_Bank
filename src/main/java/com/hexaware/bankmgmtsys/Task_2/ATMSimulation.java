package com.hexaware.bankmgmtsys.Task_2;

import java.util.Scanner;

public class ATMSimulation {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Get user's current balance
    System.out.print("Enter your current balance: $");
    double currentBalance = scanner.nextDouble();

    // Display options
    System.out.println("Select an option:");
    System.out.println("1. Check Balance");
    System.out.println("2. Withdraw");
    System.out.println("3. Deposit");

    // Get user's choice
    System.out.print("Enter your choice (1-3): ");
    int choice = scanner.nextInt();

    switch (choice) {
      case 1:
        // Check Balance
        System.out.println("Your current balance is: $" + currentBalance);
        break;
      case 2:
        // Withdraw
        System.out.print("Enter the amount to withdraw: $");
        double withdrawAmount = scanner.nextDouble();

        if (withdrawAmount <= currentBalance && withdrawAmount % 100 == 0) {
          currentBalance -= withdrawAmount;
          System.out.println(
            "Withdrawal successful. Your new balance is: $" + currentBalance
          );
        } else {
          System.out.println(
            "Withdrawal failed. Check your balance or withdrawal amount."
          );
        }
        break;
      case 3:
        // Deposit
        System.out.print("Enter the amount to deposit: $");
        double depositAmount = scanner.nextDouble();

        if (depositAmount > 0) {
          currentBalance += depositAmount;
          System.out.println(
            "Deposit successful. Your new balance is: $" + currentBalance
          );
        } else {
          System.out.println("Deposit failed. Please enter a valid deposit amount.");
        }
        break;
      default:
        System.out.println("Invalid choice. Please choose a valid option.");
    }

    scanner.close();
  }
}
