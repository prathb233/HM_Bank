package com.hexaware.bankmgmtsys.Task_14.dao;

import com.hexaware.bankmgmtsys.Task_14.model.Customer;
import com.hexaware.bankmgmtsys.Task_14.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDAO {
  Connection con;
  Statement stmt;
  PreparedStatement ps;
  ResultSet rs;

  public void createCustomer(Customer cust) {
    try {
      con = DBConnection.getDBConn();
      ps =
        con.prepareStatement(
          "INSERT INTO Customers" +
          "(first_name, last_name, DOB, email, phone_number, address)" +
          "VALUES (?,?,?,?,?,?)",
          Statement.RETURN_GENERATED_KEYS
        );
      ps.setString(1, cust.getFirstName());
      ps.setString(2, cust.getLastName());
      // Convert LocalDate to java.sql.Date
      java.sql.Date sqlDateOfBirth = java.sql.Date.valueOf(cust.getDOB());
      ps.setDate(3, sqlDateOfBirth);
      ps.setString(4, cust.getEmailAddress());
      ps.setString(5, cust.getPhoneNumber());
      ps.setString(6, cust.getAddress());
      int affectedRows = ps.executeUpdate();
      //System.out.println(no_of_rows + " inserted Successfully !!!" );

      if (affectedRows > 0) {
        // Retrieve auto-generated keys (in this case, customerID)
        ResultSet generatedKeys = ps.getGeneratedKeys();
        if (generatedKeys.next()) {
          int generatedCustomerID = generatedKeys.getInt(1);
          cust.setCustomerId(generatedCustomerID);
          System.out.println(
            "Your new Customer ID: " + generatedCustomerID +
            "\nYou can create an Account using your Customer ID"
          );
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void showCustomerDeails() {
    try {
      con = DBConnection.getDBConn();

      //stmt = con.createStatement();
      //rs = stmt.executeQuery("SELECT * FROM Customers WHERE customer_id = ?");

      String sql = "SELECT * FROM Customers WHERE customerID = ?";
      ps = con.prepareStatement(sql);
      ps.setInt(1, 16);
      rs = ps.executeQuery();

      while (rs.next()) {
        System.out.println("**************************");
        System.out.println("Customer-ID: " + rs.getInt(1));
        System.out.println("First Name: " + rs.getString(2));
        System.out.println("Last Name: " + rs.getString(3));
        System.out.println("Date of Birth: " + rs.getDate(4));
        System.out.println("Email: " + rs.getString(5));
        System.out.println("Phone: " + rs.getString(6));
        System.out.println("Address: " + rs.getString(7));
      }
    } catch (SQLException e) {
      // TODO: handle exception
    }
  }
}
