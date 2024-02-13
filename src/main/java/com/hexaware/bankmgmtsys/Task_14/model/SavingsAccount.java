package com.hexaware.bankmgmtsys.Task_14.model;

public class SavingsAccount extends Account{
	final double INTEREST_RATE = 0.075;

	public SavingsAccount(int customerId) {
		super(customerId, "Savings");
	}

    @Override //Calculate interest method
    public double calculateInterest() {
            double interest = accountBalance * INTEREST_RATE; // 7.5% interest rate for savings account
            accountBalance += interest;
            //System.out.println("\nInterest calculated and added.\nNew balance: $" + accountBalance);

            return interest;

    }
}
