package com.hexaware.bankmgmtsys.Task_3;

import java.util.Scanner;

public class CompoundInterestCalculator {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Get the number of customers
    System.out.print("Enter the number of customers: ");
    int numCustomers = scanner.nextInt();

    for (int customer = 1; customer <= numCustomers; customer++) {
      System.out.println("\nCustomer " + customer + ":");

      // Get user input for initial balance, annual interest rate, and years
      System.out.print("Enter the initial balance: $");
      double initialBalance = scanner.nextDouble();

      System.out.print("Enter the annual interest rate (%): ");
      double annualInterestRate = scanner.nextDouble();

      System.out.print("Enter the number of years: ");
      int years = scanner.nextInt();

      // Calculate the future balance
      double futureBalance = calculateFutureBalance(
        initialBalance,
        annualInterestRate,
        years
      );

      // Display the future balance
      System.out.println(
        "The future balance after " + years + " years is: $" + futureBalance
      );
    }

    scanner.close();
  }

  private static double calculateFutureBalance(
    double initialBalance,
    double annualInterestRate,
    int years
  ) {
    // Formula for compound interest
    return initialBalance * Math.pow((1 + annualInterestRate / 100), years);
  }
}
