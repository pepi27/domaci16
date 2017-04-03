package com.webshop.utils;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionManager {

	private static Connection conn = null;
	
	public static Connection getConnection() {
		if (conn == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jwts", "root", "eEflakjv39fE!fjd");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn; 
	}
	
	public static void closeConnection() {
		try {
			if(conn != null) {
				conn.close(); 
				conn = null; 
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
}