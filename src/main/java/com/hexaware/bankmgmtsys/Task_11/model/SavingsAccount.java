package com.hexaware.bankmgmtsys.Task_11.model;

public class SavingsAccount extends Account{

	public SavingsAccount(Customer customer, int accountNumber, double accountBalance) {
		super(customer, accountNumber,  "Savings", accountBalance);
	}

}
