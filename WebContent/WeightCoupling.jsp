<%@page import="com.service.*"%>
<%@page import="com.model.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Control Result</title>
<link rel="stylesheet" href="css/bootstrap.css"> 
<style>
table, td, th {
  border: 1px solid black;
}

table {
  border-collapse: collapse;
  width: 75%;
}

th {
  text-align: left;
}
input[type=button]{
                background-color: #4CAF50;
                color: white;
				              
                border: none;
                border-radius: 4px;
                cursor: pointer;
                float: center;
                
            }
</style>
</head>
<body>
	<center>
	<h1>Code Complexity Of Couplings</h1>
	<table id="dtBasicExample" class="table table-striped table-bordered table-sm">
	 <tr class="p-3 mb-2 bg-primary text-white">
	<thead>
		<th>Line no</th>
		<th>Program statements</th>
		<th>Nr</th>
		<th>Nmcms</th>
		<th>Nmcmd</th>
		<th>Nmcrms</th>
		<th>Nmcrmd</th>
		<th>Nrmcrms</th>
		<th>Nrmcrmd</th>
		<th>Nrmcms</th>
		<th>Nrmcmd</th>
		<th>Nmrgvs</th>
		<th>Nmrgvd</th>
		<th>Nrmrgvs</th>
		<th>Nrmrgvd</th>
		<th>Ccp</th>
	</tr>
	</thead>
	<tbody>
		<%
					WeightCoupling test5 = new WeightCoupling();
			ArrayList<WeiCoupling> arrayList5 = test5.coupling(session.getAttribute("test_code").toString());
			
			for (WeiCoupling coupling : arrayList5) {
				
				int Nr=coupling.getRecursive()*Integer.parseInt(session.getAttribute("recursive").toString());
				
				int Nmcms=coupling.getRegular_regular()*Integer.parseInt(session.getAttribute("regularRegular").toString());
				
				int Nmcrms=coupling.getRegular_recursive()*Integer.parseInt(session.getAttribute("regularRecursive").toString());
				
				int Nrmcrms=coupling.getRecursive_recursive()*Integer.parseInt(session.getAttribute("recursiveRecursive").toString());
				
				int Nrmcms=coupling.getRecursive_regular()*Integer.parseInt(session.getAttribute("recursiveRegular").toString());
				
				int total =Nr+Nmcms+Nmcrms+Nrmcrms+Nrmcms+(coupling.getRegular_global()*Integer.parseInt(session.getAttribute("regularGlobal").toString()))+(coupling.getRegular_regular()*Integer.parseInt(session.getAttribute("recursiveGlobal").toString()));
	            
				
		%>
				<tr class="grid">
					<td><%=coupling.getLineNumber() %></td>
					<td><%=coupling.getLine() %></td>
					<td><%=coupling.getRecursive() %></td>
					<td><%=coupling.getRegular_regular() %></td>
					<td>0</td>
					<td><%=coupling.getRegular_recursive() %></td>
					<td>0</td>
					<td><%=coupling.getRecursive_recursive() %></td>
					<td>0</td>
					<td><%=coupling.getRecursive_regular() %></td>
					<td>0</td>
					<td><%=coupling.getRegular_global() %></td>
					<td>0</td>
					<td><%=coupling.getRegular_regular() %></td>
					<td>0</td>
					<td><%=total %></td>
				</tr>
				<% 
			}	
		%>
	</tbody>
	</table>
	<a href="CommonWeight.jsp"><input type="button" id="forward" value="Back"></a>
	<br>
	<br>
	<input type="button" id="btnExport" value="Export to PDF"  />
   </center>
   
		
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
                    pdfMake.createPdf(docDefinition).download("coupling.pdf");
                }
            });
        });
      
        </script>

</body>
</html>