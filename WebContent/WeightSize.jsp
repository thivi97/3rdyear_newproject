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
	<h1>Code Complexity Of Size</h1>
	<table class="table">
	<tr>
	<thead>
		<th>Line No</th>
		<th>Program Statements</th>
		<th>Nkw</th>
		<th>Nid</th>
		<th>Nop</th>
		<th>Nnv</th>
		<th>Nsl</th>
		<th>Cs</th>
	</tr>
	</thead>
	<tbody>
    
    <%
		WeightSize test = new WeightSize();
		ArrayList<SingleLineStatement> arrayList = test.size(session.getAttribute("test_code").toString());
		
		for (SingleLineStatement sizes : arrayList) {
			
			int Nkw = sizes.getKeyword()*Integer.parseInt(session.getAttribute("sizeKeyword").toString());
			int Nid = sizes.getIdentifier()*Integer.parseInt(session.getAttribute("sizeIdentifier").toString());
			int Nop = sizes.getOperator()*Integer.parseInt(session.getAttribute("sizeOperator").toString());
			int Nnv = sizes.getNumerical()*Integer.parseInt(session.getAttribute("sizeNumerical").toString());
			int Nsl = sizes.getStringCount()*Integer.parseInt(session.getAttribute("sizeString").toString());
			int total =Nkw+Nid+Nop+Nnv+Nsl;
	%>
			<tr class="grid">
				<td scope="row"><%=sizes.getLineNumber() %></td>
				<td><%=sizes.getLine() %></td>
				<td><%=sizes.getKeyword() %></td>
				<td><%=sizes.getIdentifier() %></td>
				<td><%=sizes.getOperator() %></td>
				<td><%=sizes.getNumerical() %></td>
				<td><%=sizes.getStringCount() %></td>
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