package com.hexaware.bankmgmtsys.Task_9;

public class SavingsAccount extends BankAccount{
	
	final double INTEREST_RATE = 0.075;

    public SavingsAccount(String accountNumber, String customerName, double balance) {
        super(accountNumber, customerName, balance);
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }

    @Override
    public void calculateInterest() {
        double interest = getBalance() * INTEREST_RATE;
        setBalance(getBalance() + interest);
        System.out.println("Interest added: $" + interest);
    }
	
}

