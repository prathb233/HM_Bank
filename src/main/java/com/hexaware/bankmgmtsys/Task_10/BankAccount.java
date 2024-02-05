package com.hexaware.bankmgmtsys.Task_10;

import java.util.HashMap;
import java.util.Map;

public class BankAccount {
    private static Map<Long, Account> accounts = new HashMap<>(); //HAS-A rltn
    private long nextAccountNumber = 1001;

    public void createAccount(Customer customer, String accType, double balance) {
        long accountNumber = nextAccountNumber++;
        Account account = new Account(accountNumber, accType, balance, customer);
        accounts.put(accountNumber, account);
        System.out.println("Your Acc No. is: " + accountNumber);
    }

    public double getAccountBalance(long accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            return accounts.get(accountNumber).getAccountBalance();
        }
        return -1; // Return -1 to indicate account not found
    }

    public double deposit(long accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            Account account = accounts.get(accountNumber);
            account.setAccountBalance(account.getAccountBalance() + amount);
            return account.getAccountBalance();
        }
        return -1; // Return -1 to indicate account not found
    }

    public double withdraw(long accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            Account account = accounts.get(accountNumber);
            double currentBalance = account.getAccountBalance();
            if (currentBalance >= amount) {
                account.setAccountBalance(currentBalance - amount);
                return account.getAccountBalance();
            } else {
                System.out.println("Insufficient funds");
            }
        }
        return -1; // Return -1 to indicate account not found or insufficient funds
    }

    public void transfer(long fromAccountNumber, long toAccountNumber, double amount) {
        double withdrawResult = withdraw(fromAccountNumber, amount);
        if (withdrawResult != -1) {
            deposit(toAccountNumber, amount);
            System.out.println("Transfer successful");
        } else {
            System.out.println("Transfer failed");
        }
    }

    public void getAccountDetails(long accountNumber, int customerId) {
        if (accounts.containsKey(accountNumber)) {
            Account account = accounts.get(accountNumber);
            account.printAccountInfo(customerId);
        } else {
            System.out.println("Account not found");
        }
    }
}
