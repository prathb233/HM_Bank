package com.hexaware.bankmgmtsys.Task_9;

import java.util.Scanner;

public class Bank {

	public static void main(String[] args) {

        System.out.println("Choose account type:");
        System.out.println("1. SavingsAccount");
        System.out.println("2. CurrentAccount");
        
        try (Scanner scanner = new Scanner(System.in)) {
			int choice = scanner.nextInt();

			BankAccount account;

			switch (choice) {
			    case 1:
			        account = new SavingsAccount("101", "Raj", 1000);
			        break;
			    case 2:
			        account = new CurrentAccount("101", "Rahul", 1500);
			        break;
			    default:
			        System.out.println("Invalid choice");
			        return;
			}
			
			operateAccount(account);
		}
        
    }



    private static void operateAccount(BankAccount account) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Calculate Interest (SavingsAccount only)");
            System.out.println("4. Display Information");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter deposit amount:");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter withdrawal amount:");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 3:
                    if (account instanceof SavingsAccount) {
                        ((SavingsAccount) account).calculateInterest();
                    } else {
                        System.out.println("This operation is only applicable to SavingsAccount.");
                    }
                    break;
                case 4:
                    account.displayInfo();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    scanner.close();
            }
        }
   
    }
}

