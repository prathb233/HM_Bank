package com.hexaware.bankmgmtsys.Task_14.model;

import java.time.LocalDate;

public class Customer {
	Customer cust;

	// Default constructor
	public Customer() {}

	// Attributes
	private int customerId;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String emailAddress;
	private String phoneNumber;
	private String address;

	//private Account acc; //HAS-A relation

	// Overloaded constructor with Customer attributes
	public Customer(
		int customerId,
		String firstName, String lastName,
		LocalDate dateOfBirth,
		String emailAddress, String phoneNumber,
		String address) {
			this.customerId = customerId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.dateOfBirth = dateOfBirth;
			this.emailAddress = emailAddress;
			this.phoneNumber = phoneNumber;
			this.address = address;
	}

	// Method to print all information of attributes
	public void printCustomerInformation() {
		System.out.println("Customer ID: " + customerId);
		/*
        System.out.println("Account No.: " + acc.getAccountNo());
		System.out.println("Account Type: " + acc.getAccountType());
		System.out.println("Account Balance: " + acc.getAccountBal());
		 */
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Email Address: " + emailAddress);
		System.out.println("Phone Number: " + phoneNumber);
		System.out.println("Address: " + address);
		System.out.println();
	}

	// Getter methods declr.
	public int getCustomerId() {
		return customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public LocalDate getDOB() {
		return dateOfBirth;
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

	//Setter methods declr.
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDOB(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return (
				"Customer [customerId=" +
						customerId +
						", firstName=" +
						firstName +
						", lastName=" +
						lastName +
						", emailAddress=" +
						emailAddress +
						", phoneNumber=" +
						phoneNumber +
						", address=" +
						address +
						//+ ", acc=" + acc//
						"]"
				);
	}
}
