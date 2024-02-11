package com.hexaware.bankmgmtsys.Task_11.model;

public class CurrentAccount extends Account{

	public CurrentAccount(Customer customer, int accountNumber, double accountBalance) {
		super(customer, accountNumber,  "Current", accountBalance);
	}

}
