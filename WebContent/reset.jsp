<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RESET PASSWORD</title>
        <link rel="stylesheet" href="css/reset.css" type="text/css"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Play">
        
        <style>
            #msg{
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
                margin-right: 50px;
            }
            
            #msg.show{
                visibility: visible;
                -webkit-animation: fadein 0.5s,fadeout 0.5s 2.5s;
                animation: fadein 0.5s,fadeout 0.5s 2.5s;
            }
            
            @-webkit-keyframes fadein{
                from{top: 0; opacity: 0;}
                to{top: 30px; opacity: 1;}
            }
            
            @keyframes fadein{
                from{top: 0; opacity: 0;}
                to{top: 30px; opacity: 1;}
            }
            
            @-webkit-keyframes fadeout{
                from{top: 30px; opacity: 1;}
                to{top: 0; opacity: 0;}
            }
            
            @keyframes fadeout{
                from{top: 30px; opacity: 1;}
                to{top: 0; opacity: 0;}
            }
        </style>
    </head>
    <body>
        
         <script language="javascript">
            function fncSubmit(){
                if(document.ChangePasswordForm.OldPassword.value == ""){
                    alert('Please input old password');
                    document.ChangePasswordForm.OldPassword.focus();
                    return false;
                }
                
                if(document.ChangePasswordForm.newPassword.value == ""){
                    alert('Please input password');
                    document.ChangePasswordForm.newPassword.focus();
                    return false;
                }
                
                if(document.ChangePasswordForm.conPassword.value == ""){
                    alert('Please input confirm password');
                    document.ChangePasswordForm.conPassword.focus();
                    return false;
                }
                
                if(document.ChangePasswordForm.newPassword.value != document.ChangePasswordForm.conPassword.value){
                    alert('Password not match');
                    document.ChangePasswordForm.conPassword.focus();
                    return false;
                }
                
                document.ChangePasswordForm.submit();
            }
        </script>
        
        <div class="reset">
            <form name="ChangePasswordForm" method="post" action="Processpwd.jsp" onsubmit="return fncSubmit();">
                <h2 align="center" style="color: #fff;">Reset Password</h2>
                <input id="OLDpwd" type="password" name="OldPassword" placeholder="Old Password" required=""><br /><br /> 
                <input id="newpassword" type="password" name="newpassword" placeholder="New Password" required=""><br /><br />
                <input id="conpassword" type="password" name="conpassword" placeholder="Confirm New Password" required=""><br /><br />
                
                <input type="submit" name="submit" value="Save"/><br /><br />
                <a href="login.jsp" style="text-decoration: none;">Go back to Home Page</a><br /><br />
                <div id="msg">Your password changed successfully!</div>
                
                
            </form>
        </div>
    </body>
</html>