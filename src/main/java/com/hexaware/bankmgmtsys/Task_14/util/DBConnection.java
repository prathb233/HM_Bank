package com.hexaware.bankmgmtsys.Task_14.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	static Connection con;
	
	public static Connection getDBConn() {
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hmbank", "root", "abc123");
			
		}	catch(SQLException e) {
				e.printStackTrace();
			}
		
		return con;
	}
	
	public static void main(String[] args) {
		System.out.println(getDBConn());

	}
}

