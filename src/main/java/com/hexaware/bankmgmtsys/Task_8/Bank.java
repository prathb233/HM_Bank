package com.hexaware.bankmgmtsys.Task_8;

import java.util.Scanner;

import com.hexaware.bankmgmtsys.Task_7.Account;

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose the account type:\n"
        + "1. Savings \n2. Current \n=> : ");
        int accountType = scanner.nextInt();
        
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        Account account;

        switch (accountType) {
            case 1:
                account = new SavingsAccount(accountNumber, initialBalance);
                break;
            case 2:
                account = new CurrentAccount(accountNumber, initialBalance);
                break;
            default:
                System.out.println("Invalid account type. Exiting...");
                scanner.close();
                return;
        }
        
        
        while (true) {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Account Balance "
            		+ "\n4. Calculate Interest (for Savings Account)\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                    
                case 3:
                	System.out.println("Your current Account Balance is: " + account.getAccountBal());
                	break;
                case 4:
                    if (account.getAccountType().contentEquals("Savings")) {
                        account.calculateInterest();
                    } else {
                        System.out.println("Cannot calculate interest for an Current Account.");
                    }
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    break;
            }
        }
    }
}


