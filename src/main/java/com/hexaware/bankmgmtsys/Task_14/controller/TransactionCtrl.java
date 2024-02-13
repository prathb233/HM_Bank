package com.hexaware.bankmgmtsys.Task_14.controller;

import java.time.LocalDate;
import java.util.Scanner;

import com.hexaware.bankmgmtsys.Task_14.dao.TransactionDAO;
import com.hexaware.bankmgmtsys.Task_14.model.Transaction;

public class TransactionCtrl implements ITxn{

    Transaction txn;
    TransactionDAO dao = new TransactionDAO();
    Scanner sc = new Scanner(System.in);
    
    @Override
    public void deposit() {
	txn = new Transaction();
	
	System.out.println("Enter your Account No.:");
	int accNo = sc.nextInt();
	txn.setAccountID(accNo);
	txn.setTransactionType("Deposit");
	txn.setTransactionDate(LocalDate.now());
	
	System.out.println("Enter amount to deposit: ");
	double depAmt = sc.nextDouble();
	txn.setTransactionAmount(depAmt);
	
	dao.newTransaction(txn);
    }

    @Override
    public void withdraw() {
	txn = new Transaction();
	
	System.out.println("Enter your Account No.:");
	int accNo = sc.nextInt();
	txn.setAccountID(accNo);
	txn.setTransactionType("Withdrawal");
	txn.setTransactionDate(LocalDate.now());
	
	System.out.println("Enter amount to withdraw: ");
	double withdrAmt = sc.nextDouble();
	txn.setTransactionAmount(withdrAmt);
	dao.newTransaction(txn);
    }
    
    @Override
    public void accountTransfer() {
    	System.out.println("Enter your Account No.: ");
    	int payor = sc.nextInt();
    	//txn.setAccountID(payor);
    	
    	System.out.println("Enetr Payee's Account No.: ");
    	int payee = sc.nextInt();
    	
    	System.out.println("Enter the amount to transfer: ");
    	double tnfAmount = sc.nextDouble();
    	
    	LocalDate txnDate = LocalDate.now();
    	dao.transferTxn(payor, payee, tnfAmount, txnDate);
    }
   

}
