package com.hexaware.bankmgmtsys.Task_7;

public class Account {

	protected int accountNumber;
	protected String accountType;
	protected double accountBalance;

	// Constructors
	public Account() {
	}

	public Account(int accountNumber, String accountType, double accountBalance) {
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}


	//Getter methods declr.

	public int getAccountNo() {
		return accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public double getAccountBal() {
		return accountBalance;
	}

	//Setter methods declr.

	public void setAccountNo(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setAccountBal(double accountBalance) {
		this.accountBalance = accountBalance;
	}


	// Methods for deposits and withdrawals
	public void deposit(double amount) {
		accountBalance += amount;
		System.out.println("Deposit of " + amount + " was successfull!");
	}

	public void withdraw(double amount) {
		if (amount <= accountBalance) {
			accountBalance -= amount;
			System.out.println("Withdrawal of " + amount + " was successfull!");

		} else {
			System.out.println("Insufficient balance!");
		}
	}

	public void calculateInterest() {
		if ("Savings".equals(accountType)) {
			double interestRate = 0.045; // 4.5%
			double interestAmount = accountBalance * interestRate;
			accountBalance += interestAmount;
		}
	}

	// toString method
	@Override
	public String toString() {
		return "Account Number: " + accountNumber +
				"\nAccount Type: " + accountType +
				"\nAccount Balance: $" + accountBalance;
	}

}

