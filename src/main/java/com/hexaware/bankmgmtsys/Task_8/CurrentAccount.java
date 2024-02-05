package com.hexaware.bankmgmtsys.Task_8;

import com.hexaware.bankmgmtsys.Task_7.Account;

public class CurrentAccount extends Account{
	
	final double OVERDRAFT_LIMIT = 1000;
	
    public CurrentAccount(int accountNumber, double accountBalance) {
        super(accountNumber, "CurrentAccount", accountBalance);
    }
	
    @Override
    public void withdraw(double amount) {
    	
        double withdrawableBalance = accountBalance + OVERDRAFT_LIMIT;
        
        if (amount <= withdrawableBalance) {
            accountBalance -= amount;
        } else {
            System.out.println("Withdrawal exceeds available balance + overdraft limit");
        }
    }
}

