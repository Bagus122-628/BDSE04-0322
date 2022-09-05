package com.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.bean.RegisterBean;

public class RegisterDao {
	
	public int registerUser(RegisterBean register) throws ClassNotFoundException {
		int rowsAffected = 0;
		
		try {
			Connection connection = DBConnection.getConnectionToDatabase();
			
			// write the insert query
			String insertQuery = "INSERT INTO registration"
					+ "(`email`,`password`,`first_name`,`last_name`,`country`,`city`)"
					+ "VALUES(?,?,?,?,?,?)";
	
			// set parameters with PreparedStatement
			java.sql.PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setString(1, register.getEmail());
			statement.setString(2, register.getPassword());
			statement.setString(3, register.getFirstName());
			statement.setString(4, register.getLastName());
			statement.setString(5, register.getCountry());
			statement.setString(6, register.getCity());
			
			// execute the statement
			rowsAffected = statement.executeUpdate();

		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return rowsAffected;
	
	}
}