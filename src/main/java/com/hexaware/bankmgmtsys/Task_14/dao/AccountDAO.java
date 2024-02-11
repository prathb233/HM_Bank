package com.hexaware.bankmgmtsys.Task_14.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.bankmgmtsys.Task_14.model.Account;
import com.hexaware.bankmgmtsys.Task_14.util.DBConnection;

public class AccountDAO {

    //private static final double balance = 0;
	Connection con;
    Statement stmt;
    PreparedStatement ps;
    ResultSet rs;

    public int createAccount(Account acc) {
    	int generatedAccountNo = 0;
		try {
		    con = DBConnection.getDBConn();
		    ps = con.prepareStatement(
			    "INSERT INTO Accounts" + "(customer_id, account_type, balance)" + "VALUES (?,?,?)",
			    Statement.RETURN_GENERATED_KEYS);
	
		    ps.setInt(1, acc.getCustomerId());
		    ps.setString(2, acc.getAccountType());
		    ps.setDouble(3, acc.getAccountBal());
		    int affectedRows = ps.executeUpdate();
		    // System.out.println(no_of_rows + " inserted Successfully !!!" );
	
		    if (affectedRows > 0) {
			// Retrieve auto-generated keys (in this case, customerID)
			ResultSet generatedKeys = ps.getGeneratedKeys();
				if (generatedKeys.next()) {
				    generatedAccountNo = generatedKeys.getInt(1);
				    acc.setAccountNo(generatedAccountNo);
				}
		    }
	
		} catch (SQLException e) {// TODO Auto-generated catch block
		    e.printStackTrace();
		}
		return generatedAccountNo;
    }
    
   
    public double getAccountBalance(int accountNumber) {
    	double balance = 0.0;
    	try {
    		con = DBConnection.getDBConn();
    	    String sqlQuery = "SELECT balance FROM accounts WHERE account_id = ?";

    		ps = con.prepareStatement(sqlQuery);
    		ps.setInt(1, accountNumber);
    		rs = ps.executeQuery();
    		
    		if (rs.next()) {
    			balance = rs.getDouble("balance");
    			System.out.println("Your Account Balance is: " + balance);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return balance;
    }


		
    		
    		
    		
    		
}
