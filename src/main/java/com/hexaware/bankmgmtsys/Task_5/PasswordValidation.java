package com.hexaware.bankmgmtsys.Task_5;
import java.util.Scanner;

public class PasswordValidation {
	
	public static void main(String[] args) {
		
		// System.out.println("Enter your Acc. No.: ");
		Scanner sc = new Scanner(System.in);
                   
    	boolean isValidPassword = false;
        while (!isValidPassword) {
        	
            // Prompt the user to create a password
            System.out.print("Create a password for your bank account: ");
            String pwdInput = sc.nextLine();
            
    		if((pwdInput.length() >= 8 && checkIfUpperCase(pwdInput) && checkIfDigit(pwdInput))) {
    			isValidPassword = true;
    			System.out.println("New Password Set!");	
    		}else {
    			System.out.println("Enter a valid password!");
    		}
    		
        }
        
		sc.close();	
	}
	
	
	public static boolean checkIfUpperCase(String pwdInput) {
		for(char ch: pwdInput.toCharArray()) {
			if(Character.isUpperCase(ch)) {
			return true;
			}
		}
		return false;
	}
	
	public static boolean checkIfDigit(String pwdInput) {
		for(char ch: pwdInput.toCharArray()) {
			if(Character.isDigit(ch)) {
			return true;
			}
		}
		return false;
	}
	
}
