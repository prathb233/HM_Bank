package com.hexaware.bankmgmtsys.Task_8;

import com.hexaware.bankmgmtsys.Task_7.Account;

public class SavingsAccount extends Account{
	
	//Addtional attr of interset rate
	final double  INTEREST_RATE = 0.075;
	
    public SavingsAccount(int accountNumber, double accountBalance) {
        super(accountNumber, "SavingsAccount", accountBalance);
    }
    
    @Override
    public void calculateInterest() {
        // Use the interestRate specific to SavingsAccount
        double interestAmount = accountBalance * INTEREST_RATE;
        accountBalance += interestAmount;
        System.out.println("Interest calculated and added. New balance: " + accountBalance);

    }
}

