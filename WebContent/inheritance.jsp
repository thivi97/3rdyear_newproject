<%@ page import="com.model.FileUpload" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%
  if(request.getParameter("tx") != null){
      session.setAttribute("tx", request.getParameter("tx"));
  }  
    
%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Inheritance</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="icon" type="image/png" href="images/cde.png">
        <link rel="stylesheet" href="css/styles.css">
        <script src="https://kit.fontawesome.com/b99e675b62.js"></script>
        
        <style>
            *{
                box-sizing: border-box;
            }
            
            input[type=text], select, textarea{
                width: 80%;
                padding: 12px;
                border: 1px solid #ccc;
                border-radius: 4px;
                resize: vertical;
            }
            
            input[type=submit]{
                background-color: #4CAF50;
                color: white;
                padding: 12px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                float: right;
            }
            
            input[type=sub]{
                background-color: #4CAF50;
                color: white;
                padding: 12px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                float: center;
                margin-left: 300px;
                margin-top: 100px;
            }
            
            
        </style>
        
    </head>
    <body>
        
        <div class="wrapper">
            <div class="sidebar">
                <h2>CDE SOLUTIONS</h2>
                <ul>
                   <li><a href="indexComplexity.jsp"><i class="fas fa-home"></i>HOME</a></li>
                    <li><a href="uploadFileSVM.jsp"><i class="fas fa-size"></i>SIZE,METHOD & VARIABLE</a></li>
                    <li><a href="inheritance.jsp"><i class="fas fa-inheritance"></i>INHERITANCE</a></li>
                    <li><a href="coupling.jsp"><i class="fas fa-coupling"></i>COUPLING</a></li>
                    <li><a href="uploadPageControl.jsp"><i class="fas fa-structure"></i>CONTROL STRUCTURE</a></li>
                   
                    <li><a href="login.jsp"><i class="fas fa-total"></i>Logout</a></li>
                </ul>
                
                    
            </div>
            
        </div>
        
        			<form action="FileUploadInheritance" enctype="multipart/form-data" method="post" Style = "margin-left: 100px; margin-top: 30px;">
        			<input type="file" name="file2" class="button1"/><br>
        				 <input class = "btn btn-primary" type = "submit" name = "button" value = "Inheritance"  style = "height: 50px; width: 100px; float: right;">
        			</form>
        
                    <br>
                    <br>
                    <br>
                    <form action="codeServlet" method=POST  Style = "margin-left: 100px;" >
                        <textarea  name = "code" rows = "15" cols="100" placeholder="COPY YOUR CODE HERE"   Style = "margin-left: 130px;" >${tb}</textarea>
                        <input class = "btn btn-primary" type = "submit" name = "button" value = "Inheritance"  style = "height: 50px; width: 100px; float: right; margin-top: 50px; margin-left: 270px;">
                    
              
                      <%--   <div class="row">
                            <button type="save" onclick="alert('successful!')">SAVE</button>
                        </div>
                        --%>
                      
			
			
                    </form>    
                        
                        <br>
                        <br>
                     <!--    <a href="InheritanceWeight.jsp"><input name="btnsum2" type="sub" value="Codecomplexity weight"></a>	--> 
            </div>
            
        </div>
        
       
        
    </body>
</html>