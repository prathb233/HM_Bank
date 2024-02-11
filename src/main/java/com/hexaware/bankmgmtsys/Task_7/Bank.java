package com.hexaware.bankmgmtsys.Task_7;
			
public class Bank {
	
	public static void main(String[] args) {
		
		//Initializing an obj using parameterized constr.
		Account account1 = new Account(1001, "Savings", 1000.0);
		System.out.println(account1);
		

		// Deposit and display current balance
		double  amount = 500.0; 
		account1.deposit(amount);


		// Withdraw and display current balance
		double  amount2 = 200.0; 
		account1.withdraw(amount2);

		System.out.println("Your current balance after above txns is: " + account1.getAccountBal());
		
		// Calculate interest (for savings accounts) and display current bal.
		if ("Savings".equals(account1.getAccountType())) 
		{
			account1.calculateInterest();
			System.out.println("Your Current Balance after "
					+ "calculating interest: " + account1.getAccountBal());

		}
		
		System.out.println("______________________________________________");
		
		Account account2 = new Account();
		account2.setAccountNo(1002);
		account2.setAccountType("Savings");
		account2.setAccountBal(2300);
		
		System.out.println(account2);
		
	}
}

