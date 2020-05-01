<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complexity of Inheritance</title>
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
        
       
        
        <div class="container" style="margin-left: 15%;padding:85px; height: 500px;" >
     
          
     
     <table id="dtBasicExample" class="table table-striped table-bordered table-sm">
                <thead>
                    <tr class="p-3 mb-2 bg-primary text-white">
                       <th scope="col">Count</th>
                        <th scope="col"> Class Name</th>
                        <th scope="col">No of direct  inheritances</th>
                        <th scope="col">No of indirect  inheritances</th>
                        <th scope="col">Total inheritances</th>
                        <th scope="col">Ci</th>
                        
                    </tr>
                </thead>
	<tbody>
						<tr class="grid">
							<td>1</td>
							<td>Animal</td>
							<th scope="col">0</th>
                        <th scope="col">0</th>
                        <th scope="col">0</th>
                        <th scope="col">0</th>
						</tr>
						
						<tr class="grid">
							<td>2</td>
							<td></td>
							<th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
						</tr>
						
							<tr class="grid">
							<td>3</td>
							<td></td>
							<th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
						</tr>
						
							<tr class="grid">
							<td>4</td>
							<td> </td>
						<th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
						</tr>
						
							<tr class="grid">
							<td>5</td>
							<td></td>
							<th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
						</tr>
						
							<tr class="grid">
							<td>6</td>
							<td></td>
							<th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
						</tr>
						
							<tr class="grid">
							<td>7</td>
							<td></td>
							<th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
						</tr>
						
							<tr class="grid">
							<td>8</td>
							<td></td>
							<th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
						</tr>
						
							<tr class="grid">
							<td>9</td>
							<td></td>
							<th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
						</tr>
						
							<tr class="grid">
							<td>10</td>
							<td></td>
							<th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
						</tr>
												
							<tr class="grid">
							<td>11</td>
							<td></td>
							<th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
						</tr>
						
							
						

					</tbody>


            </table>
    
     
     <div class="row">
      
          <div class="btn1">
           <div class="bt"><a href=inheritance.jsp><button class="btn btn-primary" type="submit" data-toggle="modal" data-target="#exampleModalCenter"> Back</button></div>
  		</div>
        
     <%--       <div class="btn2">
               <div class="bt"><a href=genaratereport.jsp> <button class="btn btn-primary" type="submit" data-toggle="modal" data-target="#exampleModalCenter">Save</button></a></div>
        </div>
         --%>
         </div>
        
        
    </body>
</html>