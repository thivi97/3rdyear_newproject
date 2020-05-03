<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="asset/contactstyle.css">
<link rel="stylesheet" href="css/navigation.css">
<link rel="icon" type="image/png" href="images/cde.png">
<title>Contact Us</title>
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

<section id="contact-section">
	<div class="container">
	<h2 style="margin-top: 98px;">Contact Us</h2>
	<p>Email us and keep upto date with our latest news</p>
		<div class="contact-form">
		<!-- First grid -->
		<div>
			<i class="fa fa-map-marker"></i><span class="form-info">123 Main street Colombo-13 </span><br>
			<i class="fa fa-phone"></i><span class="form-info"> 011 245 09 78 </span><br>
			<i class="fa fa-envelope"></i><span class="form-info"> cde@gmail.com </span><br>
			
		</div>
		
		<!-- second grid -->
		<div>
			<form>
				<input type="text" placeholder="Your Name" required>
				<input type="text" placeholder="Last Name"><br>
				<input type="Email" placeholder="Email" required><br>
				<input type="text" placeholder="Subject of this message"><br>
				<textarea name="message" placeholder="Message" rows="5" required></textarea><br>
				<button class="submit">Send Message</button>
			</form>
		</div>
		</div>
	</div>		
</section>

</body>
</html>