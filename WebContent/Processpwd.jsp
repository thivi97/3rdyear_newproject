<%-- 
    Document   : Processpwd
    Created on : 31-Mar-2020, 12:57:43
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <% 
            String OldPassword = request.getParameter("OldPassword");
            String Newpass = request.getParameter("newpassword");
            String conpass = request.getParameter("conpassword");
            
            Connection con = null;
            Statement st = null;
            String pass = "";
            int id = 0;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3305/codecomplexity";
                con = DriverManager.getConnection(url,"root","msdhoni07@T");
                st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from changepassword where oldpassword = '" + OldPassword + "'");
                if(rs.next()){
                    pass = rs.getString("oldpassword");
                }
                if(Newpass.equals(conpass)){
                    if(pass.equals(OldPassword)){
                        st = con.createStatement();
                        int i = st.executeUpdate("update changepassword set oldpassword ='" + Newpass + "'");
                        out.println("Password changed successfully");
                        st.close();
                        con.close();
                    }
                    else{
                        out.println("Old Password doesn't match");
                    }
                }
            }
            catch(Exception e){
                out.println(e);
            }
        
        
        %>
    </head>
    <body>
        
    </body>
</html>
