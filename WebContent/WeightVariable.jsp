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
	<h1>Code Complexity Of Variables</h1>
	<table id="dtBasicExample" class="table table-striped table-bordered table-sm">
	 <tr class="p-3 mb-2 bg-primary text-white">
	<thead>
		<th>Line no</th>
		<th>Program statements</th>
		<th>Wvs</th>
		<th>Npdtv</th>
		<th>Ncdtv</th>
		<th>Cv</th>
	</tr>
	</thead>
	<tbody>
		<%
		WeightVariable test1 = new WeightVariable();
		ArrayList<SingleLineVariable> arrayList1 = test1.variable(session.getAttribute("test_code").toString());
		
		for (SingleLineVariable variables : arrayList1) {
			
			int Wvs =(variables.getGlobal()*Integer.parseInt(session.getAttribute("variableGlobal").toString()))+(variables.getLocal())*Integer.parseInt(session.getAttribute("variableLocal").toString());
            
            int Npdtv = variables.getGlobal()+variables.getLocal();
            
            int Cv = Wvs*((Npdtv*Integer.parseInt(session.getAttribute("variablePrimitive").toString()))+(variables.getComposite()*Integer.parseInt(session.getAttribute("variableComposite").toString())));
			
	%>
			<tr class="grid">
				<td><%=variables.getLineNumber() %></td>
				<td><%=variables.getLine() %></td>
				<td><%=Wvs %></td>
				<td><%=Npdtv %></td>
				<td><%=variables.getComposite() %></td>
				<td><%=Cv %></td>
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