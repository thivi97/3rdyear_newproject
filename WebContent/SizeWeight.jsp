<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Weight due to Size</title>
<link rel="icon" type="image/png" href="images/cde.png">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.css"> 
        <link rel="stylesheet" href="css/stylesheet.css">
       <link rel="stylesheet" href="css/styles.css">
        <script src="https://kit.fontawesome.com/b99e675b62.js"></script>

<%-- <link rel="stylesheet" href="css/weightpage.css">
<link rel="stylesheet" href="css/weightTable.css">

<script type="css/weightpage.js"></script>

--%>

</head>
<body>
	

 <div class="wrapper">
            <div class="sidebar">
                <h2>CDE SOLUTIONS</h2>
                <ul>
                    <li><a href="index.jsp"><i class="fas fa-home"></i>HOME</a></li>
                     <li><a href="uploadFileSVM.jsp"><i class="fas fa-size"></i>SIZE,METHOD & VARIABLE</a></li>
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

<h1 class="text-center" style="padding-bottom: 20px; padding-top: 20px;">Weight options related to Size</h1>

<div class="container">
<hr>

<div class="card" style="margin-left:150px;">
<table class="table table-hover shopping-cart-wrap" style="margin-left: 50px;">
<thead class="text-muted">
	<form action = "WeightSizeServlet" method= POST>
	<div style = "width : 50%; float : left;">
			<table class="table table-hover" border="1">
			<tr><th bgcolor= '#839192'>Program Component</th><th bgcolor= '#839192'>Weight</th></tr>
			<tr><td >Keyword</td><td ><input type="text" name = "Wkw" value = 1> </td></tr>
			<tr><td>Identifier</td><td><input type="text" name = "Wid" value = 1> </td></tr>
			<tr><td>Operator</td><td><input type="text" name = "Wop" value = 1> </td></tr>
			<tr><td>Numerical value</td><td><input type="text" name = "Wnv" value = 1> </td></tr>
			<tr><td>String literal</td><td> <input type="text" name = "Wsl" value = 1></td></tr>
				
			</table>
			
			</div>
			<div style = "width : 50% ;margin-top: 200px; float : right; text-align: center;">
			<input class="btn btn-info btn-arrow-right" type = "submit" name = "submit" value = "save" style = "width: 100px;height: 50px; ">
			</div>
</form>


<%-- 
<article class="bg-secondary mb-3" style="padding-bottom: 199px;">
<div class="card-body text-center">
<br>
<p>
	<a class="btn btn-warning" target="_blank" href="weightOptionpage.jsp"> Save/Back
	<i class="fa fa-window-restore"></i>
	</a>
	
	<a class="btn btn-success" target="_blank" href="uploadPage.jsp"> Save/Exit
	<i class="fa fa-window-restore"></i>
	</a>



</p>
</div>
<br>
<br>
</article>

--%>



</body>
</html>