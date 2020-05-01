<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Us</title>

<link rel="icon" type="image/png" href="images/cde.png">
<link rel="stylesheet" type="text/css" href="css/contact.min.css">
<link rel="stylesheet" type="text/css" href="fonts/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="fonts/icon-font.min.css">
<link rel="stylesheet" type="text/css" href="css/animate.css">
<link rel="stylesheet" type="text/css" href="css/hamburgers.min.css">
<link rel="stylesheet" type="text/css" href="css/animsition.min.css">
<link rel="stylesheet" type="text/css" href="css/select2.min.css">
<link rel="stylesheet" type="text/css" href="css/daterangepicker.css">

<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" href="css/navigation.css">
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
				<li><a href="index.jsp">Functions</a></li>	
				<li><a href="feedback.jsp">Feedback</a></li>
				<li><a href="contact.jsp">Contact</a></li>
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

<div class="container-contact100" >
	<div class="contact100-map" id="google_map" data-map-x="40.722047" data-map-y="-73.986422" data-pin="images/map-marker.png" data-scrollwhell="0" data-draggable="1">
	</div>
	
	<div class="wrap-contact100" style="margin-top:100px;">
		<div class="contact100-form-title" style="background-image: url(images/bg-01.jpg);">
		<span class="contact100-form-title-1"> Contact Us
		</span>
		<span class="contact100-form-title-2">Feel free to drop us a line below!</span>
		</div>
		
		<form class="contact100-form validate-form">
			<div class="wrap-input100 validate-input" date-validate="Name is required">
				<span class="label-input100">Full Name:</span>
				<input class="input100" type="text" name="name" placeholder="Enter full name">
				<span class="focus-input100"></span>
			</div>
			
			<div class="wrap-input100 validate-input" date-validate="Valid email is required: ex@abc.xyz">
				<span class="label-input100">Email:</span>
				<input class="input100" type="text" name="email" placeholder="Enter email address">
				<span class="focus-input100"></span>
			</div>
			
			<div class="wrap-input100 validate-input" date-validate="Phone is required">
				<span class="label-input100">Phone:</span>
				<input class="input100" type="text" name="phone" placeholder="Enter phone number">
				<span class="focus-input100"></span>
			</div>
			
			
			<div class="wrap-input100 validate-input" date-validate="Message is required">
				<span class="label-input100">Message:</span>
				<textarea class="input100" type="text" name="message" placeholder="Your Comment..."></textarea>
				<span class="focus-input100"></span>
			</div>
			
			<div class="container-contact100-form-btn">
				<button class="contact100-form-btn">
					<span>
						Submit
						<i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i>
					</span>
				</button>
			</div>
			
			
		</form>
	</div>

</div>

<div id="dropDownSelect1"></div>

<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/animsition.min.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/select2.min.js"></script>
<script src="js/moment.min.js"></script>
<script src="js/daterangepicker.js"></script>
<script src="js/countdowntime.js"></script>

	<script src="js/map-custom.js"></script>
	<script src="js/main.js"></script>
	
	<script async src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
	<script>
	  window.dataLayer = window.dataLayer || [];
	  function gtag(){dataLayer.push(arguments);}
	  gtag('js', new Date());

	  gtag('config', 'UA-23581568-13');
	</script>
	
	

	
	
	


</body>
</html>