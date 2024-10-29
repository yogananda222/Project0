package com.revshop.utility;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 * DatabaseConnection is a utility class that provides a method to establish a connection to the database.
 * It uses the MySQL JDBC driver to connect to the specified database.
 */
public class DatabaseConnection {
	
	public static Connection getConnection()throws Exception {
		// Load the MySQL database driver
		Class.forName("com.mysql.jdbc.Driver");
		
		// Establish the connection to the database using the specified URL, username, and password
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/revbeauty","root","193N1a0222@");
		
		// Return the established connection
		return con;
	}
	


}
