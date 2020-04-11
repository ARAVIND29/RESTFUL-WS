package com.trendnxt.topic7and8.assignment1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

	public List<Employee> getAllEmployee() throws SQLException {

		List<Employee> employees = new ArrayList<>();
		try (Connection connection = H2MemoryDatabase.getDBConnection();
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("select * from Employee");) {

			while (rs.next()) {
				Employee e = new Employee(rs.getString("id"), rs.getString("empFirstName"), rs.getString("empLastName"),
						rs.getString("empLocation"), rs.getString("empBand"));
				employees.add(e);
			}
		}
		return employees;

	}

	public int addEmployee(Employee emp) throws SQLException {

		String sql = "INSERT INTO Employee(id, empFirstName, empLastName, empLocation, empBand) VALUES(?,?,?,?,?)";
		try (Connection connection = H2MemoryDatabase.getDBConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, emp.getEmpId());
			stmt.setString(2, emp.getEmpFirstName());
			stmt.setString(3, emp.getEmpLastName());
			stmt.setString(4, emp.getEmpLocation());
			stmt.setString(5, emp.getEmpBand());
			return stmt.executeUpdate();
		}
	}

	public int updateEmployee(Employee emp) throws SQLException {
		String sql = "Update Employee set empFirstName=?, empLastName=?, empLocation=?, empBand=? where id=?";
		try (Connection connection = H2MemoryDatabase.getDBConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			stmt.setString(1, emp.getEmpFirstName());
			stmt.setString(2, emp.getEmpLastName());
			stmt.setString(3, emp.getEmpLocation());
			stmt.setString(4, emp.getEmpBand());
			stmt.setString(5, emp.getEmpId());
			return stmt.executeUpdate();
		}
	}
}
