package com.hexaware.bankmgmtsys.Task_11.model;

public class ZeroBalance extends Account{

	public ZeroBalance(Customer customer, int accountNumber, double accountBalance) {
		super(customer, accountNumber,  "Zero Balance", 0);
	}


}
