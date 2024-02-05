package com.hexaware.bankmgmtsys.Task_1;

import java.util.Scanner;

public class LoanEligibilityChecker {

  public static void main(String[] args) {
    // Create a Scanner object to read user input
    Scanner scanner = new Scanner(System.in);

    // Taking user input for credit score
    System.out.print("Enter your credit score: ");
    int creditScore = scanner.nextInt();

    // Taking user input for annual income
    System.out.print("Enter your annual income: $");
    double annualIncome = scanner.nextDouble();

    // Checking loan eligibility and displaying a message
    checkLoanEligibility(creditScore, annualIncome);

    // Close the Scanner
    scanner.close();
  }

  // Function to check loan eligibility
  private static void checkLoanEligibility(int creditScore, double annualIncome) {
    // Check if Credit Score is above 700 and Annual Income is at least $50,000
    if (creditScore > 700 && annualIncome >= 50000) {
      System.out.println("Congratulations! You are eligible for a loan.");
    } else {
      System.out.println("Sorry, you are not eligible for a loan at this time.");
    }
  }
}
