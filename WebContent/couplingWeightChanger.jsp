<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.service.MainCoupling"%>
<%@page import="com.model.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Weight due to Coupling</title>
<link rel="icon" type="image/png" href="images/cde.png">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
                    <li><a href="indexWeight.jsp"><i class="fas fa-home"></i>HOME</a></li>
                    <li><a href="sizeWeight.jsp"><i class="fas fa-size"></i>SIZE</a></li>
                    <li><a href="methodWeight.jsp"><i class="fas fa-method"></i>METHOD</a></li>
                    <li><a href="variableWeight.jsp"><i class="fas fa-variable"></i>VARIABLE</a></li>
                    <li><a href="InheritanceWeight.jsp"><i class="fas fa-inheritance"></i>INHERITANCE</a></li>
                    <li><a href="couplingWeightChanger.jsp"><i class="fas fa-coupling"></i>COUPLING</a></li>
                    <li><a href="controlWeight.jsp"><i class="fas fa-control"></i>CONTROL STRUCTURE</a></li>
                    <li><a href="indexComplexity.jsp"><i class="fas fa-total"></i>COMPLEXITY</a></li>
                    <li><a href="login.jsp"><i class="fas fa-login"></i>LOGOUT</a></li>
                </ul>
         <%--      <div class="social_media">
                    <a href="#"><i class="fab fa-fb"></i></a>
                    <a href="#"><i class="fab fa-twit"></i></a>
                    <a href="#"><i class="fab fa-insta"></i></a>
                </div>
              --%>        
            </div>
            
        </div>
        
<h1 class="text-center" style="padding-bottom: 20px; padding-top: 20px;">Weight options related to Coupling</h1>        

	<%
		ArrayList<CustomFileCoupling> fileList = (ArrayList) session.getAttribute("fileList");
	%>

	<div class="container">
 
      <div class="card" style="margin-left:150px;">
		
		<form action="UpdateCouplingWeight?update=true" method="post">
		 <div style="width:100%; height:150%; ">
			<table class="table table-hover shopping-cart-wrap" style="margin-left: 100px;">
				<thead class="text-muted">
					<tr>
						<th scope="col"><h4>Coupling Type</h4></th>
						<th scope="col"><h4>Weight</h4></th>
					</tr>
				</thead>
				<tbody>
                    <tr>
						<th scope="row"><h4>A recursive call</h4></th>
						<td><h4><input type="number" name="c1" id="c1"
							value="<% out.print(Coupling.getWeights()[0]); %>" /></h4></td>
					</tr>
					<tr>
						<th scope="row"><h4>A regular method calling another regular
							method in the same file</h4></th>
						<td><h4><input type="number" name="c2" id="c2"
							value="<% out.print(Coupling.getWeights()[1]); %>" /></h4></td>
					</tr>
					<tr>
						<th scope="row"><h4>A regular method calling another regular
							method in a different file</h4></th>
						<td><h4><input type="number" name="c3" id="c3"
							value="<% out.print(Coupling.getWeights()[2]); %>" /></h4></td>
					</tr>
					<tr>
						<th scope="row"><h4>A regular method calling a recursive method
							in the same file</h4></th>
						<td><h4><input type="number" name="c4" id="c4"
							value="<% out.print(Coupling.getWeights()[3]); %>" /></h4></td>
					</tr>
					<tr>
						<th scope="row"><h4>A regular method calling a recursive method
							in a different file</h4></th>
						<td><h4><input type="number" name="c5" id="c5"
							value="<% out.print(Coupling.getWeights()[4]); %>" /></h4></td>
					</tr>
					<tr>
						<th scope="row"><h4>A recursive method calling another recursive
							method in the same file</h4></th>
						<td><h4><input type="number" name="c6" id="c6"
							value="<% out.print(Coupling.getWeights()[5]); %>" /></h4></td>
					</tr>
					<tr>
						<th scope="row"><h4>A recursive method calling another recursive
							method in a different file</h4></th>
						<td><h4><input type="number" name="c7" id="c7"
							value="<% out.print(Coupling.getWeights()[6]); %>" /></h4></td>
					</tr>
					<tr>
						<th scope="row"><h4>A recursive method calling a regular method
							in the same file</h4></th>
						<td><h4><input type="number" name="c8" id="c8"
							value="<% out.print(Coupling.getWeights()[7]); %>" /></h4></td>
					</tr>
					<tr>
						<th scope="row"><h4>A recursive method calling a regular method
							in a different file</h4></th>
						<td><h4><input type="number" name="c9" id="c9"
							value="<% out.print(Coupling.getWeights()[8]); %>" /></h4></td>
					</tr>
					<tr>
						<th scope="row"><h4>A regular method referencing a global
							variable in the same file</h4></th>
						<td><h4><input type="number" name="c10" id="c10"
							value="<% out.print(Coupling.getWeights()[9]); %>" /></h4></td>
					</tr>
					<tr>
						<th scope="row"><h4>A regular method referencing a global
							variable in a different file</h4></th>
						<td><h4><input type="number" name="c11" id="c11"
							value="<% out.print(Coupling.getWeights()[10]); %>" /></h4></td>
					</tr>
					<tr>
						<th scope="row"><h4>A recursive method referencing a global
							variable in the same file</h4></th>
						<td><h4><input type="number" name="c12" id="c12"
							value="<% out.print(Coupling.getWeights()[11]); %>" /></h4></td>
					</tr>
					<tr>
						<th scope="row"><h4>A recursive method referencing a global
							variable in a different file</h4></th>
						<td><h4><input type="number" name="c13" id="c13"
							value="<% out.print(Coupling.getWeights()[12]); %>" /></h4></td>
					</tr>
				</tbody>
			</table>
			</div>
			
			<Button class="btn btn-primary" style="float: right; width:100px; height: 40px; " ><h4>Save</h4></Button>
			</form>
			
		 <form action="UpdateCouplingWeight?default=true" method="post" style="margin-bottom: 20px; width:100px; height: 30px;">
			<button class="btn btn-secondary" style="float: left; width:100px; height: 40px; "><h4>Set Default</h4></button>
		</form>
		
		
		</div>
	</div>
</body>
</html>