package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.model.Register;



public class RegisterDao {

	public int registeruser(Register register)throws ClassNotFoundException{
		String insert_user = "insert into userinfo"+"(fname,lname,uname,email,password,conpassword)values"+"(?,?,?,?,?,?);";
		
		int result = 0;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3305/codecomplexity?useSSL=false","root","msdhoni07@T");
			
			PreparedStatement preparedStmt = connection.prepareStatement(insert_user);
			
			preparedStmt.setString(1, register.getFname());
			preparedStmt.setString(2, register.getLname());
			preparedStmt.setString(3, register.getUname());
			preparedStmt.setString(4, register.getEmail());
			preparedStmt.setString(5, register.getPassword());
			preparedStmt.setString(6, register.getConpassword());
			
			System.out.println(preparedStmt);
			
			result = preparedStmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	
}
