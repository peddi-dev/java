package org.peddi.javase.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DrivierManagerConnectionDemo {
	
	private static final String user = "test";
	private static final String password = "admin";
	private static final String derbyDBConnURL = "jdbc:derby:testDB;create=true";
	
	
	public  Connection getConnection() {
		Connection conn = null;
		Properties connProps = new Properties();
		connProps.setProperty("user", user);
		connProps.setProperty("password", password);
		try {
			
			 conn = DriverManager.getConnection(derbyDBConnURL,
					 							connProps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) {
		
		DrivierManagerConnectionDemo app = new DrivierManagerConnectionDemo();
		System.out.println(app.getConnection());
		

	}

}
