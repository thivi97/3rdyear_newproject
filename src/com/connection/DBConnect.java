package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnect {

static Connection con = null;
    
    public static Connection getConnection()throws SQLException{
        if(con != null){
            return con;
        }
        
        String database = "codecomplexity";
        String username = "root";
        String password = "msdhoni07@T";
        return getConnection(database,username,password);
    }

    private static Connection getConnection(String database, String username, String password)throws SQLException {
       if(con == null || con.isClosed()){
           try{
               Class.forName("com.mysql.jdbc.Driver");
               con = DriverManager.getConnection("jdbc:mysql://localhost/127.0.0.1:3305/" + database + "?user=" + username + "&password=" + password);
           }catch(Exception e){
               e.printStackTrace();
           }
       }
       return con;
    }

	
}
