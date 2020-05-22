<%@page import="com.service.*"%>
<%@page import="com.model.controlstructure"%>
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
	<h1>Code Complexity Of Control</h1>
	<table id="dtBasicExample" class="table table-striped table-bordered table-sm">
	 <tr class="p-3 mb-2 bg-primary text-white">
	<thead>
		<th>Line no</th>
		<th>Program statements</th>
		<th>Wtcs</th>
		<th>NC</th>
		<th>Ccspps</th>
		<th>Ccs</th>
	</tr>
	</thead>
	<tbody>
		<%
		WeightControl test3 = new WeightControl();
		int condition= Integer.parseInt(session.getAttribute("condition").toString());
		int loop = Integer.parseInt(session.getAttribute("loop").toString());
		int switchCase= Integer.parseInt(session.getAttribute("switchCase").toString());
		int caseOnly=Integer.parseInt(session.getAttribute("caseOnly").toString());
	ArrayList<controlstructure> arrayList3 = test3.control(session.getAttribute("test_code").toString(),condition,loop,switchCase,caseOnly);
	
	for (controlstructure control : arrayList3) {
		int total = (control.getLine_weight()*control.getNo_of_control())+control.getCcspps();
%>
		<tr class="grid">
			<td><%=control.getLineNumber() %></td>
			<td><%=control.getLine() %></td>
			<td><%=control.getLine_weight() %></td>
			<td><%=control.getNo_of_control() %></td>
			<td><%=control.getCcspps() %></td>
			<td><%=total %></td>
		</tr>
		<% 
	}	
%>
	</tbody>
	</table>
	<a href="CommonWeight.jsp"><input type="button" id="forward" value="Back"></a>
	</center>
</body>
</html>