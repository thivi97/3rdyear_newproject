<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feedback</title>
<link rel="icon" type="image/png" href="images/cde.png">
<link rel="stylesheet" href="css/navigation.css">
<link rel="stylesheet" href="css/feedback.css">
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

<div id="form-outer">
	<p id="description" style="margin-top: 100px;">
		Let us know how we can improve
	</p>
	
	<form id="survey-form" method="GET" action="https://crossorigin.me/https://freecodecamp.com" style="margin-top: 100px;">
	<div class="rowTab">
		<div class="labels">
			<label id="name-label" for="name">* Name: </label>
		</div>
		<div class="rightTab">
			<input autofocus type="text" name="name" id="name" class="input-field" placeholder="Enter your name" required>
		</div>
	</div>
	
	<div class="rowTab">
		<div class="labels">
			<label id="email-label" for="email">* Email: </label>
		</div>
		<div class="rightTab">
			<input type="email" name="email" id="email" class="input-field" placeholder="Enter your email" required>
		</div>
	</div>
	
	
	<div class="rowTab">
		<div class="labels">
			<label id="number-label" for="age">* Age: </label>
		</div>
		<div class="rightTab">
			<input type="number" name="age" id="number" class="input-field" placeholder="Age" min="1" max="125" required>
		</div>
	</div>
	
	
	<div class="rowTab">
      <div class="labels">
        <label for="userRating">* How likely is that you would recommend us to a friend?</label>
      </div>
      <div class="rightTab">
        <ul style="list-style: none;">
          <li class="radio"><label>Definitely<input name="radio-buttons" value="1"  type="radio" class="userRatings" ></label></li>
          <li class="radio"><label>Maybe<input name="radio-buttons" value="2"  type="radio" class="userRatings" ></label></li>
          <li class="radio"><label>Not sure<input name="radio-buttons" value="3"  type="radio" class="userRatings" ></label></li>
        </ul>
      </div>
      
      
      <div class="rowTab">
      <div class="labels">
        <label for="most-like">What do you like most about the company: </label>
      </div>
      <div class="rightTab">
        <select id="most-like" name="mostLike" class="dropdown">
      <option disabled selected value>Select an option</option>
      <option value="challenges">Challenges</option>
      <option value="projects">Projects</option>
      <option value="community">Community</option>
      <option value="openSource">Open Source</option>
    </select>
      </div>
    </div>
	
	<div class="rowTab">
      <div class="labels">
        <label for="comments">Any Comments or Suggestions?</label>
      </div>
      <div class="rightTab">
        <textarea id="comments" class="input-field" style="height:50px;resize:vertical;" name="comment" placeholder="Enter your comment here..."></textarea>
      </div>
    </div>
    <button id="submit" type="submit">Submit</button>
	
	
	</form>
	
</div>




</body>
</html>