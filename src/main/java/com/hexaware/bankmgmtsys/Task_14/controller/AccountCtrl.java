package com.hexaware.bankmgmtsys.Task_14.controller;

import com.hexaware.bankmgmtsys.Task_14.dao.AccountDAO;
import com.hexaware.bankmgmtsys.Task_14.dao.TransactionDAO;
import com.hexaware.bankmgmtsys.Task_14.model.Account;
import com.hexaware.bankmgmtsys.Task_14.model.CurrentAccount;
import com.hexaware.bankmgmtsys.Task_14.model.Customer;
import com.hexaware.bankmgmtsys.Task_14.model.SavingsAccount;
import com.hexaware.bankmgmtsys.Task_14.model.Transaction;

import java.util.Scanner;

public class AccountCtrl implements IAcc {

    Customer cust; // creating var of type Customer
    Account acc;
    SavingsAccount savings; // creating var of type SavingsAccount
    CurrentAccount current;
    Transaction txn;
    
    AccountDAO dao = new AccountDAO();
    TransactionDAO tdao = new TransactionDAO();

    Scanner sc = new Scanner(System.in);


    @Override
    public void addAccount() {

	System.out.print("\nWhat type of Account you want to open?" 
						+ "\n1. Savings" 
						+ "\n2. Current"
						+ "\n3. Zero Balance" + "\n=> ");

	int choice = sc.nextInt();

	System.out.println("Please enter your Customer ID: ");
	int custID = sc.nextInt();
	
		switch (choice) {
			case 1: {
			    System.out.print("Deposit initial balance in your Account $");
			    double amount = sc.nextDouble();
			    
				acc = new SavingsAccount(custID, amount);
		
				int accountNumber = dao.createAccount(acc);
			    System.out.println("Your new Account No is: " + accountNumber);

//				txn = new Transaction();
//				txn.setAccountID(accountNumber);
//				txn.setTransactionAmount(amount);
//				txn.setTransactionType("Initial Deposit");
//				txn.setTransactionDate(LocalDate.now());
				
				tdao.newTransaction(txn);
			    break;
			}
		
			case 2: {
			    System.out.print("Deposit initial balance in your Account: $");
			    double amount = sc.nextDouble();
		
				current = new CurrentAccount(custID, amount);
				dao.createAccount(current);
			    break;
			}
		
			case 3: {
			    acc.setCustomerId(custID);
			    acc.setAccountType("Zero Balance");
			    System.out.print("Deposit initial balance in your Account: $");
			    int amount = sc.nextInt();
			    acc.deposit(amount);
		
			    acc.setAccountBal(0);
			    break;
			}
		
			default: {
			    System.out.println("Invalid choice. Please choose 1, 2, or 3.");
			    break; // Exiting the method since the choice is invalid
			}
		}
    }

    
    @Override
    public void viewAccount() {
	// System.out.println(dao.showAccountDetails) } // TODO Auto-generated method
	// stub
    }
}
