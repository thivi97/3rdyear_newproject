<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Weight due to Method</title>
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

<h1 class="text-center" style="padding-bottom: 20px; padding-top: 20px;">Weight options related to Method</h1>

<div class="container">
<hr>

<div class="card" style="margin-left:150px;">
<table class="table table-hover shopping-cart-wrap" style="margin-left: 50px;">
<thead class="text-muted">

	<form action = "WeightMethodsServlet" method= POST>
	<div style = "width : 50%; float : left;">
			<table class="table table-hover" border="1">
			<tr><th bgcolor= '#839192'>Program Component</th><th bgcolor= '#839192'>Weight</th></tr>
			<tr><td >Method with a primitive return type</td><td ><input type="text" name = "WmrtP" value = 1> </td></tr>
			<tr><td>Method with a composite return type</td><td><input type="text" name = "WmrtC" value = 1> </td></tr>
			<tr><td>Method with a void return type</td><td><input type="text" name = "WmrtV" value = 1> </td></tr>
			<tr><td>Primitive data type parameter</td><td><input type="text" name = "Wpdtp" value = 1> </td></tr>
			<tr><td>Composite data type parameter</td><td> <input type="text" name = "Wcdtp" value = 1></td></tr>
				
			</table>
			
			</div>
			<div style = "width : 50% ;margin-top: 200px; float : right; text-align: center;">
			<input class="btn btn-info btn-arrow-right" type = "submit" name = "submit" value = "save" style = "width: 200px;height: 50px">
			</div>
</form>


</div>
</thead></table></div></div>
<br>
<br>



</body>

</html>