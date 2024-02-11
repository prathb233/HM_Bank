package com.hexaware.bankmgmtsys.Task_11.main;

import java.util.Scanner;

import com.hexaware.bankmgmtsys.Task_11.Controller.AccountCtrl;

public class BankMain {
	static Scanner sc = new Scanner(System.in);
	static AccountCtrl accCtrl = new AccountCtrl();;
	
	public static void main(String[] args) {
		
		System.out.print("Are you an exsiting customer?"
				+ "\n1. Yes \n2.No \n=> ");
		int choice = sc.nextInt();
		
		switch(choice) {
			case 1:{
				System.out.println(
						  "\n1. Deposit"
						+ "\n2. Withdraw"
						+ "\n3. Transfer"
						+ "\n4. View Account Balance");
				int operation = sc.nextInt();
				
				switch(operation) {
					case 1: {
						
					}
					case 2: {
						
					}
					case 3: {
						
					}
					case 4: {
						
					}
					default: {
						
					}
				}
			}
			
			case 2:{
				accCtrl.createAccount(sc);
			}
			
			default:{
				
			}
		}
		
		
	}

}
