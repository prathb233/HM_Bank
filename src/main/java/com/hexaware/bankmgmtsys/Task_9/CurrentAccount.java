package com.hexaware.bankmgmtsys.Task_9;

public class CurrentAccount extends BankAccount{
	
	private static final double OVERDRAFT_LIMIT = 1000;

    public CurrentAccount(String accountNumber, String customerName, double balance) {
        super(accountNumber, customerName, balance);
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }

    @Override
    public void withdraw(double amount) {
    	double withdrawableAmount = getBalance() + OVERDRAFT_LIMIT;
        if (amount <= withdrawableAmount) {
            setBalance(getBalance() - amount);
        } else {
            System.out.println("Withdrawal limit exceeded.");
        }
    }

    @Override
    public void calculateInterest() {
        // Current account has no interest
    }
}

