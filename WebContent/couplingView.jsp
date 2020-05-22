<%@page import="com.service.MainCoupling"%>
<%@page import="com.model.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<title>Complexity Coupling</title>
<link rel="icon" type="image/png" href="images/cde.png">
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
				<a class="nav-link" href="uploadFileSVM.jsp">Size,Variable & method</a>
			  </li>
			  
			  <li class="nav-item ">
				<a class="nav-link" href="inheritance.jsp">Inheritance</a>
			  </li>
			  <li class="nav-item active">
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

	<%
		ArrayList<CustomFileCoupling> main = (ArrayList) session.getAttribute("fileList");
	%>
	<div class="main-container">

		<%
			for (CustomFileCoupling file : main) {
				int[] sum = new int[13];
		%>
		<center>
			<h3>
				<%
					out.print(file.getFileName());
				%>
			</h3>
		</center>
		<br /> <br />
		<table id="dtBasicExample"  class="table table-bordered" class="table table-striped table-bordered table-sm">
			<tr class="p-3 mb-2 bg-primary text-white">
				<th>Line No</th>
				<th>Program Statement</th>
				<th>Nr</th>
				<!--col1 A recursive call -->
				<th>Nmcms</th>
				<!--col2 A regular method calling another regular method in the same file done-->
				<th>Nmcmd</th>
				<!--col3 A regular method calling another regular method in a different file done-->
				<th>Nmcrms</th>
				<!--col4 A regular method calling a recursive method in the same file done-->
				<th>Nmcrmd</th>
				<!--col5 A regular method calling a recursive method in a different file done-->
				<th>Nrmcrms</th>
				<!--col6 A recursive method calling another recursive method in the same file done-->
				<th>Nrmcrmd</th>
				<!--col7 A recursive method calling another recursive method in a different file done-->
				<th>Nrmcms</th>
				<!--col8 A recursive method calling a regular method in the same file done-->
				<th>Nrmcmd</th>
				<!--col9 A recursive method calling a regular method in a different file done-->
				<th>Nmrgvs</th>
				<!--col10 A regular method referencing a global variable in the same file done-->
				<th>Nmrgvd</th>
				<!--col11 A regular method referencing a global variable in a different file done-->
				<th>Nrmrgvs</th>
				<!--col2 A recursive method referencing a global variable in the same file -->
				<th>Nrmrgvd</th>
				<!--col13 A recursive method referencing a global variable in a different file -->
				<th>Ccp</th>
				<!--col14 total -->
			</tr>
			<%
				int count = 0;
						for (LineCoupling line : file.getLineSet()) {
			%>
			<tr>
				<%
					int col1 = 0;
							int col2 = 0;
							int col3 = 0;
							int col4 = 0;
							int col5 = 0;
							int col6 = 0;
							int col7 = 0;
							int col8 = 0;
							int col9 = 0;
							int col10 = 0;
							int col11 = 0;
							int col12 = 0;
							int col13 = 0;
							int col14 = 0;
				%>
				<td>
					<%
						out.print(line.getLineNumber());
					%>
				</td>
				<td class="lineSet">
					<%
						out.print(line.getLineContent());
					%>
				</td>
				<td>
					<%
						out.print(line.getSum()[0]);
					%>
				</td>
				<td>
					<%
						out.print(line.getSum()[1]);
					%>
				</td>
				<td>
					<%
						out.print(line.getSum()[2]);
					%>
				</td>
				<td>
					<%
						out.print(line.getSum()[3]);
					%>
				</td>
				<td>
					<%
						out.print(line.getSum()[4]);
					%>
				</td>
				<td>
					<%
						out.print(line.getSum()[5]);
					%>
				</td>
				<td>
					<%
						out.print(line.getSum()[6]);
					%>
				</td>
				<td>
					<%
						out.print(line.getSum()[7]);
					%>
				</td>
				<td>
					<%
						out.print(line.getSum()[8]);
					%>
				</td>
				<td>
					<%
						out.print(line.getSum()[9]);
					%>
				</td>
				<td>
					<%
						out.print(line.getSum()[10]);
					%>
				</td>
				<td>
					<%
						out.print(line.getSum()[11]);
					%>
				</td>
				<td>
					<%
						out.print(line.getSum()[12]);
					%>
				</td>
				<td>
					<%
						out.print(line.getFinalValue());
					%>
				</td>
			</tr>
			<%
				}
			%>
			<tr>
				<td></td>
				<td></td>
				<td>
					<%
						out.print(file.getCoupling().getSum()[0]);
					%>
				</td>
				<td>
					<%
						out.print(file.getCoupling().getSum()[1]);
					%>
				</td>
				<td>
					<%
						out.print(file.getCoupling().getSum()[2]);
					%>
				</td>
				<td>
					<%
						out.print(file.getCoupling().getSum()[3]);
					%>
				</td>
				<td>
					<%
						out.print(file.getCoupling().getSum()[4]);
					%>
				</td>
				<td>
					<%
						out.print(file.getCoupling().getSum()[5]);
					%>
				</td>
				<td>
					<%
						out.print(file.getCoupling().getSum()[6]);
					%>
				</td>
				<td>
					<%
						out.print(file.getCoupling().getSum()[7]);
					%>
				</td>
				<td>
					<%
						out.print(file.getCoupling().getSum()[8]);
					%>
				</td>
				<td>
					<%
						out.print(file.getCoupling().getSum()[9]);
					%>
				</td>
				<td>
					<%
						out.print(file.getCoupling().getSum()[10]);
					%>
				</td>
				<td>
					<%
						out.print(file.getCoupling().getSum()[11]);
					%>
				</td>
				<td>
					<%
						out.print(file.getCoupling().getSum()[12]);
					%>
				</td>
				<td>
					<%
						out.print(file.getCoupling().getFinalValue());
					%>
				</td>
			</tr>
		</table>
		<br>
		<br>
		<br>
		
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.22/pdfmake.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>
    <script type="text/javascript">
        $("body").on("click", "#btnExport", function () {
            html2canvas($('#dtBasicExample')[0], {
                onrendered: function (canvas) {
                    var data = canvas.toDataURL();
                    var docDefinition = {
                        content: [{
                            image: data,
                            width: 500
                        }]
                    };
                    pdfMake.createPdf(docDefinition).download("Coupling.pdf");
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
		<%
			}
		%>
	</div>
	<div>
	<br>
	<br>
		<center>
		<br>
			<div class="btn btn-primary"
				onclick="window.location.href = 'couplingWeightChanger.jsp';">ChangeWeights
		</center>
		
		<center>
		<br>
		<br>
		<div class="btn btn-primary">
		<input type="button" id="btnExport" value="Export to pdf" style="background-color: #4CAF50; border-radius: 4px; " />
		&emsp;<button onclick="exportTableToExcel('dtBasicExample', 'inheritance')" style="background-color: #4CAF50; border-radius: 4px; ">Export To CSV</button>
		</center>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>