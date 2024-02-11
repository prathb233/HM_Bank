package com.hexaware.bankmgmtsys.Task_11.model;


public class Account {

	protected int accountNumber;
	protected String accountType;
	protected double accountBalance;
	protected Customer customer;

	// Constructors
	public Account() {
	}

	public Account(Customer customer, int accountNumber, String accountType, double accountBalance) {
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.customer = customer;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountType="
				+ accountType + ", accountBalance=" + accountBalance
				+ ", customer=" + customer + "]";
	}

}
