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
                    <li><a href="size.jsp"><i class="fas fa-size"></i>SIZE</a></li>
                    <li><a href="method.jsp"><i class="fas fa-method"></i>METHOD</a></li>
                    <li><a href="variable.jsp"><i class="fas fa-variable"></i>VARIABLE</a></li>
                    <li><a href="inheritance.jsp"><i class="fas fa-inheritance"></i>INHERITANCE</a></li>
                    <li><a href="coupling.jsp"><i class="fas fa-coupling"></i>COUPLING</a></li>
                    <li><a href="control.jsp"><i class="fas fa-structure"></i>CONTROL STRUCTURE</a></li>
                    <li><a href="#"><i class="fas fa-total"></i>TOTAL</a></li>
                    <li><a href="indexWeight.jsp"><i class="fas fa-weight"></i>WEIGHT</a></li>
                    <li><a href="login.jsp"><i class="fas fa-total"></i>Logout</a></li>
                </ul>
                
                    
            </div>
            
        </div>
        
        <div id="result1">
            <div style="margin-left: 25%; padding: 1px 16px;height: 1000px;">
                <div class="row">
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <div>
                        <h3>Choose File to upload </h3>
                        <br>
                        
                        <form action= 'FileSelectServlet'>
<%
FileUpload fu = new FileUpload();
out.print(fu.getFileList());
%>
 Select<input type="file" name="file_name"/>
                            <a href="Result.jsp"><input type="submit" value="Inheritance"/></a>

</form>
              
                           
                        
                        
                    </div>
                    <br>
                    <br>
                    <br>
                    <form action="codeServlet" method=POST>
                        <textarea  name = "code" rows = "15" cols="100" placeholder="COPY YOUR CODE HERE"   Style = "" >${tb}</textarea>
                        
                    
                </div>
                      <%--   <div class="row">
                            <button type="save" onclick="alert('successful!')">SAVE</button>
                        </div>
                        --%>
                      
			<input class = "btn btn-primary" type = "submit" name = "button" value = "Inheritance"  style = "height: 50px; width: 100px; float: left;">
			
                    </form>    
                        
                        <br>
                        <br>
                     <!--    <a href="InheritanceWeight.jsp"><input name="btnsum2" type="sub" value="Codecomplexity weight"></a>	--> 
            </div>
            
        </div>
        
       
        
    </body>
</html>