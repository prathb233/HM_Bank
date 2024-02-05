package com.hexaware.bankmgmtsys.Task_14.controller;

import com.hexaware.bankmgmtsys.Task_14.dao.AccountDAO;
import com.hexaware.bankmgmtsys.Task_14.model.Account;
import com.hexaware.bankmgmtsys.Task_14.model.Customer;

import java.util.Scanner;

public class AccountCtrl implements IAcc {

    Customer cust; // creating var of type Customer
    Account acc; // creating var of type

    AccountDAO dao = new AccountDAO();

    Scanner sc = new Scanner(System.in);


    @Override
    public void addAccount() {

	acc = new Account();

	System.out.print("\nWhat type of Account you want to open?" 
						+ "\n1. Savings" 
						+ "\n2. Current"
						+ "\n3. Zero Balance" + "\n=> ");

	int choice = sc.nextInt();

	System.out.println("Please enter your Customer ID: ");

	int custID = sc.nextInt();

	switch (choice) {
	case 1: {
	    acc.setCustomerId(custID);
	    acc.setAccountType("Savings");

	    System.out.print("Deposit initial balance in your Account $");
	    int amount = sc.nextInt();
	    acc.deposit(amount);

	    acc.setAccountBal(acc.getAccountBal()+amount);
	    break;
	}

	case 2: {
	    acc.setCustomerId(custID);
	    acc.setAccountType("Current");
	    System.out.print("Deposit initial balance in your Account: $");
	    int amount = sc.nextInt();
	    acc.deposit(amount);

	    acc.setAccountBal(0);
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

	System.out.println("Account created successfully!");
	dao.createAccount(acc);

    }

    
    @Override
    public void viewAccount() {
	// System.out.println(dao.showAccountDetails) } // TODO Auto-generated method
	// stub
    }
}
