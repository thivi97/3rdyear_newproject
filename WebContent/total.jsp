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
	<h1>Code Complexity Of All</h1>
	<table class="table">
	<tr>
	<thead>
		<th>Line no</th>
		<th>Program statements</th>
		<th>Cs</th>
		<th>Cv</th>
		<th>Cm</th>
		<th>Ci</th>
		<th>Ccp</th>
		<th>Ccs</th>
		<th>TCps</th>
	</tr>
	</thead>
	<tbody>
		<%
			WeightSize test = new WeightSize();
			ArrayList<SingleLineStatement> arrayList = test.size(session.getAttribute("test_code").toString());
			
			WeightVariable test1 = new WeightVariable();
			ArrayList<SingleLineVariable> arrayList1 = test1.variable(session.getAttribute("test_code").toString());
			
			WeightMethod test2 = new WeightMethod();
			ArrayList<SingleLineMethods> arrayList2 = test2.method(session.getAttribute("test_code").toString());
			
			WeightCoupling test5 = new WeightCoupling();
			ArrayList<WeiCoupling> arrayList5 = test5.coupling(session.getAttribute("test_code").toString());
			
			WeightControl test3 = new WeightControl();
					int condition= 2;
					int loop = 3;
					int switchCase= 2;
					int caseOnly=1;
			ArrayList<controlstructure> arrayList3 = test3.control(session.getAttribute("test_code").toString(),condition,loop,switchCase,caseOnly);
			
			int totalCs=0;
			int totalCv=0;
			int totalCm=0;
			int totalCcs=0;
			int totalCi=0;
			int totalCcp=0;
			
			WeightInheritance test4 = new WeightInheritance();
			ArrayList<InheritanceModel> arrayList4 = test4.inheritance(session.getAttribute("test_code").toString());
			
			for (int i = 0; i <arrayList4.size();i++) {
				int Ci=arrayList4.get(i).getNo_of_direct_inheritances() +arrayList4.get(i).getNo_of_indirect_inheritances();
				if(Ci==0){
					Ci=0;
				}else if(Ci==1){
	                Ci=1;
	            }else if(Ci==2){
	                Ci=2;
	            }else if(Ci==3){
	                Ci=3;
	            }else if(Ci>4){
	                Ci=4;
	            }
				totalCi=totalCi+Ci;
			}
			
			for (int i = 0; i <arrayList.size();i++) {
				
				int Cs =arrayList.get(i).getKeyword()+arrayList.get(i).getIdentifier()+arrayList.get(i).getOperator()+arrayList.get(i).getNumerical()+arrayList.get(i).getStringCount();
				totalCs=totalCs+Cs;
				
				int Wvs =(arrayList1.get(i).getGlobal()*2)+arrayList1.get(i).getLocal();
	            
	            int Npdtv = arrayList1.get(i).getGlobal()+arrayList1.get(i).getLocal();
	            
	            int Cv = Wvs*(Npdtv+arrayList1.get(i).getComposite()*2);
				
	            totalCv=totalCv+Cv;
				
				int Wmrt =(arrayList2.get(i).getComposite_method()*2)+arrayList2.get(i).getPrimitive_method();
	            
	            int Cm = Wmrt+(arrayList2.get(i).getPrimitive_parameters()+(arrayList2.get(i).getComposite_parameters()*2));
				
	            totalCm=totalCm+Cm;
	            
	            int Ccs = (arrayList3.get(i).getLine_weight()*arrayList3.get(i).getNo_of_control())+arrayList3.get(i).getCcspps();
				
	            totalCcs=totalCcs+Ccs;
	            
				int Nr=arrayList5.get(i).getRecursive()*2;
				
				int Nmcms=arrayList5.get(i).getRegular_regular()*2;
				
				int Nmcrms=arrayList5.get(i).getRegular_recursive()*3;
				
				int Nrmcrms=arrayList5.get(i).getRecursive_recursive()*4;
				
				int Nrmcms=arrayList5.get(i).getRecursive_regular()*3;
				
				int Ccp =Nr+Nmcms+Nmcrms+Nrmcrms+Nrmcms+arrayList5.get(i).getRegular_global()+arrayList5.get(i).getRegular_regular();
	            
				totalCcp=totalCcp+Ccp;
				
				int rowTotal=Cs+Cv+Cm+Ccp+Ccs;
				
		%>
				<tr>
					<td><%=arrayList.get(i).getLineNumber() %></td>
					<td><%=arrayList.get(i).getLine() %></td>
					<td><%=Cs %></td>
					<td><%=Cv %></td>
					<td><%=Cm %></td>
					<td>0</td>
					<td><%=Ccp %></td>
					<td><%=Ccs %></td>
					<td><%=rowTotal %></td>
				</tr>
				<% 
			}	
			int total=totalCs+totalCv+totalCm+totalCi+totalCcp+totalCcs;
		%>
		<tr>
					<td></td>
					<td>Total</td>
					<td><%=totalCs %></td>
					<td><%=totalCv %></td>
					<td><%=totalCm %></td>
					<td><%=totalCi %></td>
					<td><%=totalCcp %></td>
					<td><%=totalCcs %></td>
					<td><%=total %></td>
				</tr>
	</tbody>
	</table>
	</center>
</body>
</html>