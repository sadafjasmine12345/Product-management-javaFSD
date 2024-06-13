package com.pace.product.helper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
	private static Connection connection = null;

	// Opening connection with MYSQL database
	public static Connection createConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		// If error occurs type the following code
		//Class.forName("com.mysql.cj.jdbc.Driver"); 
		
		connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/product","root","Sai@#786");
		return connection;
	}

	// Closing connection
	public static void closeConnection() throws SQLException {
		connection.close();
	}
}


