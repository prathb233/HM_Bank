package com.hexaware.bankmgmtsys.Task_7;
			
public class Bank {
	
	public static void main(String[] args) {
		
		// Creating an obj using parameterized constr.
		Account account1 = new Account(123456789, "Savings", 1000.0);
		System.out.println(account1);
		

		// Deposit and display current balance
		double  amount = 500.0; 
		account1.deposit(amount);
		System.out.println("\nDeposit of " + amount + " was successfull!"
				+ "\nCurrent Balance: " + account1.getAccountBal());


		// Withdraw and display current balance
		double  amount2 = 200.0; 
		account1.withdraw(amount2);
		System.out.println("\nWithdrawal of " + amount2 + " was successfull!"
				+ "\nCurrent Balance: " + account1.getAccountBal());


		// Calculate interest (for savings accounts) and display current bal.
		if ("Savings".equals(account1.getAccountType())) 
		{
			account1.calculateInterest();
			System.out.println("\nYour Current Balance after "
					+ "calculating interest: " + account1.getAccountBal());

		}
	}
}

