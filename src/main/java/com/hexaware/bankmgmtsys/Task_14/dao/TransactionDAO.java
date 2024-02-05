package com.hexaware.bankmgmtsys.Task_14.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.hexaware.bankmgmtsys.Task_14.model.Transaction;
import com.hexaware.bankmgmtsys.Task_14.util.DBConnection;

public class TransactionDAO {
    Connection con;
    Statement stmt;
    PreparedStatement ps;
    ResultSet rs;
    
    public void newTransaction(Transaction txn) {
	try {
	    con = DBConnection.getDBConn();
	    ps = con.prepareStatement(
		"INSERT INTO Transactions (account_id, transaction_type, amount, transaction_date)" + 
		"VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
	    
	    ps.setInt(1, txn.getAccountID());
	    ps.setString(2, txn.getTransactionType());
	    ps.setDouble(3, txn.getTransactionAmount());
	    ps.setObject(4, txn.getTransactionDate());
	    int affectedRows = ps.executeUpdate();
	    
	    if (affectedRows > 0) {
		// Retrieve auto-generated keys (in this case, customerID)
		ResultSet generatedKeys = ps.getGeneratedKeys();
		if (generatedKeys.next()) {
		    int generatedTxnId = generatedKeys.getInt(1);
		    txn.setTransactionID(generatedTxnId);
		    System.out.println(txn.getTransactionType() +" of amount $" + txn.getTransactionAmount() +" was succesfull!"
		    		+ "\nYour Transaction ID is: " + generatedTxnId);
		}
	    }
			  
	} catch (SQLException e) {// TODO Auto-generated catch block
	    e.printStackTrace();
	}   
    }
    
    public void transferTxn(int payor, int payee, double tnfAmount, LocalDate txnDate) {
    	try {
    	    con = DBConnection.getDBConn();
    	    ps = con.prepareStatement(
    		"INSERT INTO Transactions (account_id, transaction_type, amount, transaction_date)" + 
    		"VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
    	    
    	    ps.setInt(1, payor);
    	    ps.setString(2, "IMPS Tranfer debit");
    	    ps.setDouble(3, tnfAmount);
    	    ps.setObject(4, txnDate);
    	    int affectedRows = ps.executeUpdate();
    	    
    	    if (affectedRows > 0) {
    		// Retrieve auto-generated keys (in this case, customerID)
    		ResultSet generatedKeys = ps.getGeneratedKeys();
    		if (generatedKeys.next()) {
    		    int generatedTxnId = generatedKeys.getInt(1);
    		    Transaction txn = new Transaction();
    		    txn.setTransactionID(generatedTxnId);
    		    System.out.println("Transfer of $" + tnfAmount + " was successfull!"
    		    		+ "\nYour Transaction ID is: " + generatedTxnId);
    		}
    	    } 
    	    
    	    ps = con.prepareStatement(
    		"INSERT INTO Transactions (account_id, transaction_type, amount, transaction_date)" + 
    		"VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
    	    
    	    ps.setInt(1, payee);
    	    ps.setString(2, "IMPS Transfer credit");
    	    ps.setDouble(3, tnfAmount);
    	    ps.setObject(4, txnDate);
    	    int affectedRows2 = ps.executeUpdate();
    	    
    	    if (affectedRows2 > 0) {
    		// Retrieve auto-generated keys (in this case, customerID)
    		ResultSet generatedKeys = ps.getGeneratedKeys();
    		if (generatedKeys.next()) {
//    			int generatedTxnId = generatedKeys.getInt(1);
//    		    txn.setTransactionID(generatedTxnId);
//    		    System.out.println("Your Transaction ID is: " + generatedTxnId);
    		}
    	    }
    			  
    	} catch (SQLException e) {// TODO Auto-generated catch block
    	    e.printStackTrace();
    	} 
    }

}

