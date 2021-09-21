package com.revature.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.app.dao.EmployeeDao;
import com.revature.app.dao.Util;
import com.revature.app.model.Department;
import com.revature.app.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Employee> list() throws SQLException {
		List<Employee> employeeList = new ArrayList<>();
		try (Connection connection = Util.getConnection()) {

			String sql = "select *\r\n" + 
					"from employee e\r\n" + 
					"inner join department d\r\n" + 
					"on e.department_id = d.id;";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {

				Employee employee = new Employee();
				employee.setId(resultset.getInt("id"));
				employee.setName(resultset.getString("name"));
				employee.setSalary(resultset.getDouble("salary"));
				employee.setGender(resultset.getString("gender").charAt(0));
				
				Department department = new Department();
				department.setId(resultset.getInt("d.id"));
				department.setName(resultset.getString("d.name"));
				employee.setDepartment(department);
				
				employeeList.add(employee);
			}
			employeeList.forEach(System.out::println);
		}
		return employeeList;
	}

	@Override
	public Employee get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Employee employee) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Employee employee) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

}
