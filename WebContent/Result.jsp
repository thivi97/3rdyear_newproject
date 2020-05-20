<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.io.PrintWriter"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="icon" type="image/png" href="images/cde.png">
		<link rel="stylesheet" href="css/bootstrap.css"> 
        <link rel="stylesheet" href="css/stylesheet.css">
       <link rel="stylesheet" href="css/styles.css">
        <script src="https://kit.fontawesome.com/b99e675b62.js"></script>
</head>
<body>

<div class="wrapper">
            <div class="sidebar">
                <h2>CDE SOLUTIONS</h2>
                <ul>
                    <li><a href="#"><i class="fas fa-home"></i>HOME</a></li>
                    <li><a href="size.jsp"><i class="fas fa-size"></i>SIZE</a></li>
                    <li><a href="method.jsp"><i class="fas fa-method"></i>METHOD</a></li>
                    <li><a href="variable.jsp"><i class="fas fa-variable"></i>VARIABLE</a></li>
                    <li><a href="inheritance.jsp"><i class="fas fa-inheritance"></i>INHERITANCE</a></li>
                    <li><a href="coupling.jsp"><i class="fas fa-coupling"></i>COUPLING</a></li>
                    <li><a href="control.jsp"><i class="fas fa-structure"></i>CONTROL STRUCTURE</a></li>
                    <li><a href="#"><i class="fas fa-total"></i>TOTAL</a></li>
                    <li><a href="login.jsp"><i class="fas fa-total"></i>Logout</a></li>
                </ul>
         <%--      <div class="social_media">
                    <a href="#"><i class="fab fa-fb"></i></a>
                    <a href="#"><i class="fab fa-twit"></i></a>
                    <a href="#"><i class="fab fa-insta"></i></a>
                </div>
              --%>        
            </div>
            
        </div>
        
        <table>
		<thead>
			<tr>
				<th>Line No</th>
				<th>Class Name</th>
				<th>No of Direct Inheritance</th>
				<th>No of Indirect Inheritance</th>
				<th>Total Inheritance</th>
				<th>Ci</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var = "inheritanceList" items="${inheritanceList}">
			<tr>
					<td>${inheritanceList.getCount() }</td>
					<td>${inheritanceList.getClassName()}</td>
					<td>${inheritanceList.getNo_di()}</td>
					<td>${inheritanceList.getNo_ini()}</td>
					<td>${inheritanceList.getTot_in()}</td>
					<td>${inheritanceList.getCi()}</td>
			</tr>
			</c:forEach>
		</tbody>
		
		</table>

</body>
</html>