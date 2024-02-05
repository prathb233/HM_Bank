package com.hexaware.bankmgmtsys.Task_10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
	
	static int nextCustomerID = 1;
	static Map<Integer, Customer> customerList = new HashMap<>();

    private int customerId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private String address;
    //creating new customer using Map

    public void createCustomer(Scanner scanner) {
		// Gather customer details
		System.out.println("\nEnter customer details:");
		System.out.print("First Name: ");
		String firstName = scanner.nextLine();
		System.out.print("Last Name: ");
		String lastName = scanner.nextLine();
		System.out.print("Email Address: ");
		String emailAddress = scanner.nextLine();
		System.out.print("Phone Number: ");
		String phoneNumber = scanner.nextLine();
		System.out.print("Address: ");
		String address = scanner.nextLine();
		
		customerId = nextCustomerID++;
		Customer newCustomer = new Customer(customerId, firstName, lastName, emailAddress, phoneNumber, address);
		customerList.put(customerId, newCustomer);
	    System.out.println("Customer ID: " + newCustomer.getCustomerId());

		
    }
    
    
    // Default constructor
    public Customer() {
    }

    // Overloaded constructor with all attributes
    public Customer(int customerId, String firstName, String lastName, String emailAddress, String phoneNumber, String address) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        setEmailAddress(emailAddress);
        setPhoneNumber(phoneNumber);
        this.address = address;
    }

    
    // Getter methods
    public int getCustomerId() {
        return customerId;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public String getEmailAddress() {
        return emailAddress;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public String getAddress() {
        return address;
    }
    
    
    //Setter methods
//    public void setCustomerId(int customerId) {
//        this.customerId = customerId;
//    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Validate and set email address
    public void setEmailAddress(String emailAddress) {
        if (isValidEmail(emailAddress)) {
            this.emailAddress = emailAddress;
        } else {
            throw new IllegalArgumentException("Invalid email address");
        }
    }


    // Validate and set phone number
    public void setPhoneNumber(String phoneNumber) {
        if (isValidPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException("Invalid phone number");
        }
    }

    public void setAddress(String address) {
        this.address = address;
    }


    // Validate email address using regex
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Validate 10-digit phone number using regex
    private boolean isValidPhoneNumber(String phoneNumber) {
        String phoneRegex = "^\\d{10}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
    
    // Method to print all information of the customer
    public void printCustomerInfo(int customerId) {
        System.out.println("\nCustomer ID: " + customerList.get(customerId).getCustomerId());
        System.out.println("First Name: " + customerList.get(customerId).getFirstName());
        System.out.println("Last Name: " + customerList.get(customerId).getLastName());
        System.out.println("Email Address: " + customerList.get(customerId).getEmailAddress());
        System.out.println("Phone Number: " + customerList.get(customerId).getPhoneNumber());
        System.out.println("Address: " + customerList.get(customerId).getAddress());
    }
}


