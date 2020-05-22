<%@page import="com.service.*"%>
<%@page import="com.model.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Control Result</title>

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
</style>
</head>
<body>
	<center>
	<h1>Code Complexity Of Methods</h1>
	<table class="table">
	<tr>
	<thead>
		<th>Line no</th>
		<th>Program statements</th>
		<th>Wmrt</th>
		<th>Npdtp</th>
		<th>Ncdtp</th>
		<th>Cm</th>
	</tr>
	</thead>
	<tbody>
	
	<%
		WeightMethod test2 = new WeightMethod();
		ArrayList<SingleLineMethods> arrayList2 = test2.method(session.getAttribute("test_code").toString());
		
		for (SingleLineMethods methods : arrayList2) {
			
			int Wmrt =(methods.getComposite_method()*Integer.parseInt(session.getAttribute("methodComposite").toString()))+(methods.getPrimitive_method()*Integer.parseInt(session.getAttribute("methodPrimitive").toString()));
		          
          	int Cm = Wmrt+((methods.getPrimitive_parameters()*Integer.parseInt(session.getAttribute("methodPrimitiveData").toString()))+(methods.getComposite_parameters()*Integer.parseInt(session.getAttribute("methodCompositeData").toString())));
			
		%>
		<tr>
			<td><%=methods.getLineNumber() %></td>
			<td><%=methods.getLine() %></td>
			<td><%=Wmrt %></td>
			<td><%=methods.getPrimitive_parameters() %></td>
			<td><%=methods.getComposite_parameters() %></td>
			<td><%=Cm %></td>
		</tr>
		<% 
		}	
		%>
	
	</tbody>
	</table>
	</center>
</body>
</html>