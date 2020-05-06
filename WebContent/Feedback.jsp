<!-- Done -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feedback</title>
<link rel="icon" type="image/ico" href="https://image.flaticon.com/icons/svg/813/813364.svg" />
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/navigation.css">
<link rel="icon" type="image/png" href="images/cde.png">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Do+Hyeon" rel="stylesheet">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
   <link rel="stylesheet" type="text/css" href="css/link.css">
   <style type="text/css">
  	.frame {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
	width:50%;
height:80%;
background-color: rgba(0,0,100,0.2);
margin-left: 400px;
margin-top: 100px;

}
body
{
  background: url(https://www.netplanner.it/wp-content/uploads/2016/12/design.jpg);
 background-size:cover;
}
.t{
  color: white;
  /*font-family: 'Lato', sans-serif;*/
  font-family: 'Do Hyeon', sans-serif;
}
</style>
</head>
<body>

<nav class="nav">
	<div class="container">
		<div class="logo">
			<a href="#">CED|Solution </a>
		</div>

		<div class="main_list" id="mainListDiv">
			<ul>
				<li><a href="Home.jsp">Home</a></li>
				<li><a href="aboutus.jsp">About Us</a></li>	
				<li><a href="index.jsp">Complexity</a></li>	
				<li><a href="#">Weight</a></li>		
				<li><a href="Feedback.jsp">Feedback</a></li>
				<li><a href="Contactus.jsp">Contact</a></li>
			</ul>
		</div>	
		
		<div class="media_button">
			<button class="main_media_button" id="mediaButton">
				<span></span>
				<span></span>
				<span></span>
			</button>
		</div>	
		
	</div>
	
</nav>


	<div class="frame t" >
		<form action="" >
			<div class="form-group row" >
				<label for="name" class="col-sm-2 col-form-label">Name</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" placeholder="Enter Full Name">
				</div>
			</div>
			
			<div class="form-group row">
				<label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
				<div class="col-sm-10">
					<input type="email" class="form-control" id="inputEmail3" placeholder="Enter Email">
				</div>
			</div>
			
			
			<div class="form-group row">
				<div class="col-sm-2">Feedback</div>
				<div class="col-sm-10">
				<div class="form-group">
					<textarea class="form-control" id="exampleFormControlTextarea1" rows="3" placeholder="Write your feedback here..."></textarea>
				</div>
			</div>
			</div>
			<div class="form-group row">
  	<div class="col-sm-2"></div>
  	<div class="col-sm-10">
  		<div class="form-group">
    <button class="btn btn-primary btn-lg " type="button">submit</button>
  </div>
  	</div>
  	</div>
		</form>
	</div>	

</body>
</html>