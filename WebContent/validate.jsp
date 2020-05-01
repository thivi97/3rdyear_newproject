<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%
            try{
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CodeComplexity" + "user=root&password=");
                PreparedStatement pst = conn.prepareStatement("Select uname,pwd from login where uname=? and pwd=?");
                pst.setString(1,username);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();
                if(rs.next())
                    out.println("Valid login");
                else
                    out.println("Invalid login");
                       
            
            }
            catch(Exception e){
                out.println("Something went wrong!! Please try again");
                e.printStackTrace();
            }
            
            
            
            
            
            
            
            
            %>
    </head>
<body>

</body>
</html>