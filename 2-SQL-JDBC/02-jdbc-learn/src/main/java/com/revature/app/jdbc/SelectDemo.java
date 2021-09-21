package com.revature.app.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.app.model.Employee;

public class SelectDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learndb", "root",
					"Rushi@123");
			System.out.println("connection successful.");
			String sql = "select * from employee";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();
			List<Employee> employeeList = new ArrayList<>();
			while (resultset.next()) {
				
				Employee employee = new Employee();
				employee.setId(resultset.getInt("id"));
				employee.setName(resultset.getString("name"));
				employee.setSalary(resultset.getDouble("salary"));
				employee.setGender(resultset.getString("gender").charAt(0));
				//employee.setDepartmentId(resultset.getInt("department_id"));
				employeeList.add(employee);
				
			
			}
			employeeList.forEach(System.out::println);

			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
