<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.io.PrintWriter"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.service.ControlStructureCalculation"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complexity due to Control Structure</title>
<link rel="icon" type="image/png" href="images/cde.png">
		<link rel="stylesheet" href="css/bootstrap.css"> 
	
        <link rel="stylesheet" href="css/stylesheet.css">
       <link rel="stylesheet" href="css/styles.css">
        <script src="https://kit.fontawesome.com/b99e675b62.js"></script>
		
		
		<style>
			 input[type=button]{
                background-color: #4CAF50;
                color: white;
				margin-left: 450px;               
                border: none;
                border-radius: 4px;
                cursor: pointer;
                float: center;
                
            }
		</style>
		
</head>
<body>
<%
	
//ControlStructureCalculationMain cs1=new ControlStructureCalculationMain();
//String documentName =cs1.getPath();


	String rows;

	ArrayList<String> row = new ArrayList<>();
	
	
		row.add(rows);

	
	
	ControlStructureCalculation complexity = new ControlStructureCalculation(row);
	
	ArrayList<Integer> Count = complexity.cntrolrow();
	ArrayList<Integer> WTC = complexity.wtcrow();
	ArrayList<Integer> NC = complexity.ncrow();
	ArrayList<Integer> Ccspps = complexity.ccsppsrow();

%>
<!--  
<div class="wrapper">
            <div class="sidebar">
                <h2>CDE SOLUTIONS</h2>
                <ul>
                    <li><a href="#"><i class="fas fa-home"></i>HOME</a></li>
                    <li><a href="size.jsp"><i class="fas fa-size"></i>SIZE</a></li>
                    <li><a href="method.jsp"><i class="fas fa-method"></i>METHOD</a></li>
                    <li><a href="variable.jsp"><i class="fas fa-variable"></i>VARIABLE</a></li>
                    <li><a href="inheritance.jsp"><i class="fas fa-inheritance"></i>INHERITANCE</a></li>
                    <li><a href="coupling.jsp"><i class="fas fa-coupling"></i>COUPLING</a></li>
                    <li><a href="control.jsp"><i class="fas fa-structure"></i>CONTROL STRUCTURE</a></li>
                    <li><a href="#"><i class="fas fa-total"></i>TOTAL</a></li>
                    <li><a href="login.jsp"><i class="fas fa-total"></i>Logout</a></li>
                </ul>
         <%--      <div class="social_media">
                    <a href="#"><i class="fab fa-fb"></i></a>
                    <a href="#"><i class="fab fa-twit"></i></a>
                    <a href="#"><i class="fab fa-insta"></i></a>
                </div>
              --%>        
            </div>
            
        </div>
        -->
        
        <h3 style="margin-left: 300px; margin-top:50px; ">Complexity due to Control Structure</h3>
        
        <br><br><br>
        
     <table id="dtBasicExample" class="table table-striped table-bordered table-sm">
		<thead>
		
		     <tr>
		    <th>Line Number</th>
		    <th>Source Code</th>
		    <th>Wtc</th>
		    <th>Nc</th>
		    <th>A</th>
		    <th>Ccspps</th>
		    <th>Ccs</th>
		  </tr>
		</thead>
		
			<tbody>
		<%
		for(int i = 0; i < row.size(); i++) {
		
		%>
	
			<tr>
				<td><%=(i+1) %></td>
			    <td><%=row.get(i) %></td>
			    <td><%=WTC.get(i) %></td>
			    <td><%=NC.get(i) %></td>
			    <td><%=Count.get(i) %></td>
			    <td><%=Ccspps.get(i) %></td>
			    <td><%=(Count.get(i)+Ccspps.get(i)) %></td>
			    
			</tr>
			
	
		<%
		}
		%> 
		</tbody>
	</table>
		
			
		<br>
		<br>
		<br>
		
		<a href="control.jsp"><input type="button" id="forward" value="Back"></a>
		<input type="button" id="btnExport" value="Export to PDF"  />
		<button onclick="exportTableToExcel('dtBasic', 'control')" style="background-color: #4CAF50; border-radius: 4px; ">Export To CSV</button>
         <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.22/pdfmake.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>
    <script type="text/javascript">
    
        $("body").on("click", "#btnExport", function () {
            html2canvas($('#dtBasic')[0], {
                onrendered: function (canvas) {
                    var data = canvas.toDataURL();
                    var docDefinition = {
                        content: [{
                            image: data,
                            width: 500
                        }]
                    };
                    pdfMake.createPdf(docDefinition).download("inheritance.pdf");
                }
            });
        });
        
        function exportTableToExcel(tableID,filename = '') {
            var downloadLink;
            var dataType = 'application/vnd.ms-excel';
            var tableSelect = document.getElementById(tableID);
            var tableHTML = tableSelect.outerHTML.replace(/ /g, '%20');
            
            // Specify file name
            filename = filename?filename+'.xls':'excel_data.xls';
            
            // Create download link element
            downloadLink = document.createElement("a");
            
            document.body.appendChild(downloadLink);
            
            if(navigator.msSaveOrOpenBlob){
                var blob = new Blob(['\ufeff', tableHTML], {
                    type: dataType
                });
                navigator.msSaveOrOpenBlob( blob, filename);
            }else{
                // Create a link to the file
                downloadLink.href = 'data:' + dataType + ', ' + tableHTML;
            
                // Setting the file name
                downloadLink.download = filename;
                
                //triggering the function
                downloadLink.click();
            }
        }
        
    </script>

		
</body>
</html>