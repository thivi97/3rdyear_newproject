<%@page import="com.service.WeightInheritance"%>
<%@page import="com.service.InheritanceModel"%>
<%@page import="com.model.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Control Result Inheritance</title>
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
	<h1>Code Complexity Of Inheritance</h1>
	<table id="dtBasicExample" class="table table-striped table-bordered table-sm">
	 <tr class="p-3 mb-2 bg-primary text-white">
	<thead>
		<th>Count</th>
		<th>Class Name</th>
		<th>No of direct inheritances</th>
		<th>No of indirect inheritances</th>
		<th>Total inheritances</th>
		<th>Ci</th>
	</tr>
	</thead>
	<tbody>
		<%
				WeightInheritance test4 = new WeightInheritance();
		ArrayList<InheritanceModel> arrayList4 = test4.inheritance(session.getAttribute("test_code").toString());
		
		for (InheritanceModel inheritance : arrayList4) {
			int total = inheritance.getNo_of_direct_inheritances() +inheritance.getNo_of_indirect_inheritances();
			
			int Ci=total;
			if(Ci==0){
				Ci=Integer.parseInt(session.getAttribute("Inheritance").toString());
			}else if(Ci==1){
                Ci=Integer.parseInt(session.getAttribute("Inheritance1").toString());
            }else if(Ci==2){
                Ci=Integer.parseInt(session.getAttribute("Inheritance2").toString());
            }else if(Ci==3){
                Ci=Integer.parseInt(session.getAttribute("Inheritance3").toString());
            }else if(Ci>4){
                Ci=Integer.parseInt(session.getAttribute("Inheritance4").toString());
            }
	%>
			<tr class="grid">
				<td><%=inheritance.getLineNumber() %></td>
				<td><%=inheritance.getClassName() %></td>
				<td><%=inheritance.getNo_of_direct_inheritances() %></td>
				<td><%=inheritance.getNo_of_indirect_inheritances() %></td>
				<td><%=total %></td>
				<td><%=Ci %></td>
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
                    pdfMake.createPdf(docDefinition).download("inheritance.pdf");
                }
            });
        });
      
        </script>
	
	
</body>
</html>