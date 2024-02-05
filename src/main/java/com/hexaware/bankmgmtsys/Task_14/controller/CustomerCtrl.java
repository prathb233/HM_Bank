package com.hexaware.bankmgmtsys.Task_14.controller;

import com.hexaware.bankmgmtsys.Task_14.dao.CustomerDAO;
import com.hexaware.bankmgmtsys.Task_14.model.Customer;

import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;

public class CustomerCtrl implements ICust {
	Customer cust; //creating var of type Customer
	//Account acc; //creating var of type Account

	CustomerDAO dao = new CustomerDAO();

	Scanner sc = new Scanner(System.in);

	//List<Customer> custList = new ArrayList<Customer>();
	@Override
	public void addCustomer() {
		cust = new Customer(); //why we did this?

		System.out.println("\n---Please enter your details---\n");

		System.out.print("First Name: ");
		String firstName = sc.next();
		cust.setFirstName(firstName);

		System.out.print("Last Name: ");
		String lastName = sc.next();
		cust.setLastName(lastName);

		System.out.print("Date of Birth (YYYY-MM-DD): ");
		LocalDate dateOfBirth = LocalDate.parse(sc.next());
		cust.setDOB(dateOfBirth);

		System.out.print("Email-Id: ");
		String emailAddress = sc.next();
		cust.setEmailAddress(emailAddress);

		System.out.print("Mobile number: ");
		String phoneNumber = sc.next();
		cust.setPhoneNumber(phoneNumber);

		System.out.print("Address: ");
		String address = sc.next();
		cust.setAddress(address);

		//custList.add(cust);

		System.out.println("Customer details were added succesfully!");
		dao.createCustomer(cust);
	}

	@Override
	public void viewCustomer() {
		//System.out.println(custList);
		dao.showCustomerDeails();
	}
}
