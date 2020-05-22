<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Coupling</title>
 <link rel="icon" type="image/png" href="images/cde.png">
 <link rel="stylesheet" href="css/styles.css">
  <script src="https://kit.fontawesome.com/b99e675b62.js"></script>
  <script src="js/uploadfile.js"></script>
  
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
                   <li><a href="index.jsp"><i class="fas fa-home"></i>HOME</a></li>
                    <li><a href="size.jsp"><i class="fas fa-size"></i>SIZE</a></li>
                    <li><a href="method.jsp"><i class="fas fa-method"></i>METHOD</a></li>
                    <li><a href="variable.jsp"><i class="fas fa-variable"></i>VARIABLE</a></li>
                    <li><a href="inheritance.jsp"><i class="fas fa-inheritance"></i>INHERITANCE</a></li>
                    <li><a href="coupling.jsp"><i class="fas fa-coupling"></i>COUPLING</a></li>
                    <li><a href="control.jsp"><i class="fas fa-structure"></i>CONTROL STRUCTURE</a></li>
                    <li><a href="#"><i class="fas fa-total"></i>TOTAL</a></li>
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
                          <form action="UploadServletCoupling" method="post" enctype="multipart/form-data" name="form1" id="form1">
						   <input type="text" id="filename" style="width: 50%;float: left;" />
								<label>Browse <input name="file" type="file" id="file" multiple style="display: none;" onChange="uploadOnChange(this)">
						       </label>
						        <br>
						        <br>
						        <input type="submit" name="submit" value="Proceed" style="width: 10%;float: right" />
						   </form>
						   </br>
						   <br>
					  </div>
					  <br>
                      <br>
                      <br>
                      <form method="post" action="index.jsp">
                        <textarea name="tx" placeholder="Write Something..." style="height: 200px">${requestScope["message"]}</textarea>
                        
                    
                </div>
                        
                    </form>    
                        
            </div>
            
        </div>
	
</body>
</html>
