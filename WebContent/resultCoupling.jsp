<%@page import="com.service.MainCoupling"%>
<%@page import="com.model.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.model.*"%>
<%@ page import="com.service.*"%>
<%@ page import="com.servlet.*"%>
<%@ page import="com.util.*"%>
<!DOCTYPE html>
<html>
<head>
<title>Coupling result Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="css/bootstrap.css"> 
<link rel="stylesheet" href="css/stylesheet.css">
<link rel="stylesheet" href="css/styles.css">
<script src="https://kit.fontawesome.com/b99e675b62.js"></script>
<link rel="icon" type="image/png" href="images/cde.png">
<script src="js/resultPage.js"></script>
</head>
<body>
	
	<div id="resultContainer">
		<div id="coupling" class="coupling">
			
				<%@ include file="couplingView.jsp"%>
		</div>
		
	</div>
		<br />
		
		<br />
	</div>

</body>
</html>