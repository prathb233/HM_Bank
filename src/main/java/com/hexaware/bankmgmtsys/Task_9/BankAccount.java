package com.hexaware.bankmgmtsys.Task_9;

public abstract class BankAccount {
	
	// Attributes
    private String accountNumber;
    private String customerName;
    private double balance;

    // Constructors
    public BankAccount() {
        // Default constructor
    }

    public BankAccount(String accountNumber, String customerName, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }

    // Getters and setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Abstract methods
    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public abstract void calculateInterest();

    // Display information method
    public void displayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Balance: $" + balance);
    }
}

