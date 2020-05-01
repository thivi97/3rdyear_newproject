<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
 <link rel="stylesheet" href="css/signup.css" type="text/css"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Play">
        <script type="text/javascript" src="validate.js"></script>
        <style>
            #msg1{
                visibility: hidden;
                min-width: 250px;
                background-color: yellow;
                color: #000;
                text-align: center;
                border-radius: 2px;
                padding: 16px;
                position: fixed;
                z-index: 1;
                right: 30%;
                top: 30px;
                font-size: 17px;
                margin-right: 30px;
            }
            
            #msg1.show{
                visibility: visible;
                -webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
                animation: fadein 0.5s, fadeout 0.5s 2.5s;
            }
            
            @-webkit-keyframes fadein{
                from{top:0; opacity: 0;}
                to{top: 30px; opacity: 1;}
            }
            
            @keyframes fadein{
                from{top:0; opacity: 0;}
                to{top: 30px; opacity: 1;}
            }
            
            @-webkit-keyframes fadeout{
                from{top: 30px; opacity: 1;}
                to{top: 0; opacity: 0;}
            }
            
            @keyframes fadeout{
                from{top: 30px; opacity: 1;}
                to{top:0; opacity:0;}
            }
            
        </style>
        
        <script>
            function validate(){
                var fname = document.form.fname.value;
                var lname = document.form.lname.value;
                var uname = document.form.uname.value;
                var email = document.form.email.value;
                var password = document.form.password.value;
                var conpassword = document.form.conpassword.value;
                
                if(fname == null || fname ==""){
                    alert("First name can't be blank");
                    return false;
                }
                
                else if(lname == null || lname ==""){
                    alert("Last name can't be blank");
                    return false;
                }
                
                else if(uname == null || uname ==""){
                    alert("User name can't be blank");
                    return false;
                }
                
                else if(email == null || email ==""){
                    alert("Email can't be blank");
                    return false;
                }
                
                else if(password.length < 6){
                    alert("Password must be at least 6 character long");
                    return false;
                }
                
                else if(password != conpassword){
                    alert("Confirm password should match with the password");
                    return false;
                }
            }
        </script>
        
    </head>
    <body>
        <div class="signup">
            <form name="form" method="POST" action="RegisterServlet">
                 <h1 style="color: #fff;">Sign Up</h1>
                 <input type="text" name="fname" placeholder="First Name" required=""><br /><br />
                 <input type="text" name="lname" placeholder="Last Name" required=""><br /><br />
                 <input type="text" name="uname" placeholder="User Name" required=""><br /><br />
                 <input type="text" name="email" placeholder="Email Address" required=""><br /><br />
                 <input type="password" name="password" placeholder="Password" required=""><br /><br />
                 <input type="password" name="conpassword" placeholder="Confirm Password" required=""><br /><br />
                 <input type="submit" value="Sign Up" onclick="myFunction()" ><br /><br />
                 <div id="msg1">Congratulations you Sign up successfully!!</div>
                 <div id="msg1">Field cannot be empty!!</div>
                 
         
                 
                 
                  
                 Already have account? <a href="login.jsp" style="text-decoration: none; font-family: 'Play',sans-serif; color: yellow;">&nbsp;LogIn</a>
            </form>
            
            
        </div> 
        
         <script>
                     $(document).ready(function(){
                         $("#regform").validate({
                             rules: {
                                 pass:
                                         {
                                             equalTo: "#pass1"
                                         }
                             }
                         });
                     });
                     
                     
                     
                 </script>

</body>
</html>