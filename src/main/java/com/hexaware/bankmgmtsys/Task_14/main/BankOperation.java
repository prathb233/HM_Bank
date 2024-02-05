package com.hexaware.bankmgmtsys.Task_14.main;

import com.hexaware.bankmgmtsys.Task_14.controller.*;
import com.hexaware.bankmgmtsys.Task_14.dao.AccountDAO;

//import com.bankmgmtsys.Task_14.model.*;
import java.util.Scanner;

public class BankOperation {

    public static void main(String[] args) {
	ICust custI = new CustomerCtrl();
	IAcc accI = new AccountCtrl();
	ITxn txnI = new TransactionCtrl();
	AccountDAO accDAO = new AccountDAO();

	Scanner sc = new Scanner(System.in);

	System.out.println("Welcome to HM Bank \n");
	System.out.print("Are you an existing customer? \n1. Yes \n2. No \n=> ");
	int choice = sc.nextInt();

	switch (choice) {
	//For existing customers
	case 1: {
	    System.out.println(
	    "\nChoose Your Operation" + 
	    "\n1. Deposit \n2. Withdraw \n3. View Account Balance" + 
		"\n4. Transfer");
	    
	    int choice2 = sc.nextInt() ;
	    
	    switch(choice2) {
	    case 1: {
		txnI.deposit();
		break;
	    }
	    case 2: {
		txnI.withdraw();
		break;
	    }
	    case 3:{
	    	System.out.println("Enter your Account No.: ");
	    	int accNo = sc.nextInt();
	    	accDAO.getAccountBalance(accNo);
	    	break;
	    }
	    case 4: {
	    	txnI.accountTransfer();
	    }
	    
	    }
	    break;
	}
	//For new customers
	case 2:{
	    custI.addCustomer();
	    custI.viewCustomer();
	    accI.addAccount();
	    accI.viewAccount();

	    break;
	}
	default:{
	    System.out.println("Enter a valid Choice !!!");
	    break;
	}
	}

	//Calculate interest for Savings account
	//acc1.calculateInterest();
	sc.close();
    }
}
