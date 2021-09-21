package com.revature.app.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/learndb",
					"root",
					"Rushi@123");
			System.out.println("connection successful.");
			String sql = "insert into department (name) values ('Innovation')";
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);

			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
