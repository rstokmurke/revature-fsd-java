package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bankapp.dao.EmployeeDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Employee> list() throws SQLException {
		List<Employee> accountList = new ArrayList<>();
		try (Connection connection = Util.getConnection()) {

			String sql ="SELECT accountNo, balance, status FROM bankapp.account where status = 'N'";
				
			PreparedStatement statement = connection.prepareStatement(sql);
			//statement.setInt(1,CustomerDaoImpl.currentCustomerId);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {

				Employee account = new Employee("dd","ff","rr", 05,'N');
				//account.setId(resultset.getInt("id"));
				account.setAccountNo(resultset.getString("accountNo"));
				account.setBalance(resultset.getDouble("balance"));
				account.setStatus(resultset.getCharacterStream("status"));
				//statement.setInt(1,CustomerDaoImpl.currentCustomerId);
				//account.setCustomerid(resultset.getInt("customerid"));
				
				/*Department department = new Department();
				department.setId(resultset.getInt("d.id"));
				department.setName(resultset.getString("d.name"));
				employee.setDepartment(department);*/
				
				accountList.add(account);
			}
			accountList.forEach(System.out::println);
		}
		return accountList;
	}

}
