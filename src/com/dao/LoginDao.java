package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class LoginDao {

	public static boolean validate(String uname,String passwrd){
		boolean status = false;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String url = "jdbc:mysql://localhost:3305/";
		String dbName = "codecomplexity";
		String driver = "com.mysql.jdbc.Driver";
		String username = "root";
		String password = "msdhoni07@T";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url +dbName,username,password);
			
			pst = conn.prepareStatement("select * from userinfo where uname=? and password=?");
			
			pst.setString(1, uname);
			pst.setString(2, passwrd);
			
			rs = pst.executeQuery();
			status = rs.next();
			
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst != null) {
				try {
					pst.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return status;
		
		
		}
	}
	

