package com.hexaware.bankmgmtsys.Task_14.model;

public class Account {	    
    
	//Attributes
	protected int accountNumber;
	protected int customerID;
	protected String accountType;
	protected double accountBalance;
	
	//default Constr
	public Account() {}
	
	//Constr overload 1
	public Account(int accountNumber, int customerId, String accountType, double accountBalance) {
		this.accountNumber = accountNumber;
		this.customerID = customerId;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}
	
	//overload 2
	public Account(int customerId, String accountType) {
		this.customerID = customerId;
		this.accountType = accountType;
		//this.accountBalance = accountBalance;
	}
	
	
	//Getter methods declr.
	
	public int getAccountNo() {
		return accountNumber;
	}
	
	public int getCustomerId() {
		return customerID;
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
	
	public void setCustomerId(int customerId) {
		this.customerID = customerId;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public void setAccountBal(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	
	//Deposit method
	public void deposit(int amount) {
		accountBalance += amount;
		System.out.println("Deposit of " + amount + " is successfull! \nNew Balance: $" + accountBalance);
	}
	
	//Withdraw method
	public void withdraw(int amount) {
		if(amount <= accountBalance) {
			accountBalance -= amount;
			System.out.println("\nWithdrawal of " + amount + " is successfull! \nNew Balance: $" + accountBalance);
		}else {
			System.out.println("\nInsufficient Balance!. withdraw lesser amount...");
		}
	}
		
    //Calculate interest method
    public double calculateInterest() {
            double interest = accountBalance * 0.045; // 4.5% interest rate
            accountBalance += interest;
            //System.out.println("\nInterest calculated and added.\nNew balance: $" + accountBalance);

            return interest;

    }

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", customerID="
				+ customerID + ", accountType=" + accountType
				+ ", accountBalance=" + accountBalance + "]";
	}
   
    
}

	

