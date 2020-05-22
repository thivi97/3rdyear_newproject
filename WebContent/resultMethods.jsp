<%@page import="com.model.SingleLineMethods"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result Method</title>
<link rel="icon" type="image/png" href="images/cde.png">
		<link rel="stylesheet" href="css/bootstrap.css"> 
        <link rel="stylesheet" href="css/stylesheet.css">
       <link rel="stylesheet" href="css/styles.css">
        <script src="https://kit.fontawesome.com/b99e675b62.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	  </button>

	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<a class="navbar-brand" href="#">CDE IT Solutions</a>
		</ul>
		
		<div class="my-2 my-lg-0">
		  <ul class="navbar-nav mr-auto">
			  <li class="nav-item">
			  <a class="nav-link" href="uploadFileSVM.jsp">SIZE,METHOD & VARIABLE</a>			  
			  </li>
			  <li class="nav-item ">
				<a class="nav-link" href="inheritance.jsp">Inheritance</a>
			  </li>
			  <li class="nav-item">
				<a class="nav-link" href="coupling.jsp">Coupling</a>
			  </li>
			  <li class="nav-item">
				<a class="nav-link" href="controlstructures.jsp">Control structures</a>
			  </li>
			  <li class="nav-item">
				<a class="nav-link" href="allfactors.jsp">All Factors</a>
			  </li>
			</ul>
		</div>
	  </div>
	</nav>
	<% List<SingleLineMethods> lines = (List<SingleLineMethods>)request.getAttribute("statementList"); %>
	<h1>Code Complexity due to Methods</h1>
	<table id="tab-01" class="table table-striped table-bordered table-sm">
	<tr class="p-3 mb-2 bg-primary text-white">
		<th>Line No</th>
		<th>Program Statements</th>
		<th>WMRT</th>
		<th>Npdtp</th>
		<th>Ncdtp</th>
		<th>Cm</th>
	</tr>
	<%
		for(SingleLineMethods line : lines){
			%>
				<tr>
				<td><%=line.getLineNumber() %></td>
				<td><%=line.getStatement() %></td>
				<td><%=line.getWmrt() %></td>
				<td><%=line.getNpdtp() %></td>
				<td><%=line.getNcdtp() %></td>
				<td><%=line.getCm() %></td>
				</tr>
			<%
		}
	%>
	</table>
	<input type="button" id="btnExport" value="Export"  />
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.22/pdfmake.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>
    <script type="text/javascript">
        $("body").on("click", "#btnExport", function () {
            html2canvas($('#tab-01')[0], {
                onrendered: function (canvas) {
                    var data = canvas.toDataURL();
                    var docDefinition = {
                        content: [{
                            image: data,
                            width: 500
                        }]
                    };
                    pdfMake.createPdf(docDefinition).download("Method.pdf");
                }
            });
        });
        function exportTableToExcel(tableID, filename = ''){
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