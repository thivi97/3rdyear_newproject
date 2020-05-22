<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Analyze your code by statements or variables or methods</title>
        
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
        
        <div id="result1">
            <div style="margin-left: 25%; padding: 1px 16px;height: 1000px;">
                <div class="row">
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <div>
  
    <body> 
        <div>
            <h3> Choose File to Upload in Server </h3>
            <form action="UploadFileServlet" method="post" enctype="multipart/form-data">
                <input type="file" name="uploadFile" />
                <br/>
                <input name = "submitBtn" type="submit" value="By Variable" />
                <br><br><br>
                <input name = "submitBtn" type="submit" value="By Statement" />
                <br><br><br>
                <input name = "submitBtn" type="submit" value="By Methods" />
                <br><br><br>
            </form>  
            
            <br>
                    <form method="post" action="index.jsp">
                        <textarea name="tx" placeholder="Write Something..." style="height: 200px">${requestScope["message"]}</textarea>
                        
                    
                </div>
                        <div class="row">
                            <button type="save" onclick="alert('successful!')">SAVE</button>
                        </div>
                    </form>    
                       <%-- <a href="result.jsp"><input name="btnsum2" type="submit" value="next"></a>--%> 
            </div>
                    
        </div>
       
    </body>
</html>