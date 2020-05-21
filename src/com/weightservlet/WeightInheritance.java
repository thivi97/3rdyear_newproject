package com.weightservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Inheritance;
import com.service.InheritanceModel;
import com.servlet.codeServlet;

@WebServlet("/WeightInheritance")
public class WeightInheritance extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WeightInheritance() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String button = request.getParameter("submit");
		
		String zero = request.getParameter("zero");
		String one = request.getParameter("one");
		String two = request.getParameter("two");
		String three = request.getParameter("three");
		String four = request.getParameter("four");
		
		if(button.equals("save")) {
			Inheritance inherit = new Inheritance();
			inherit.setWeights(Integer.parseInt(zero), Integer.parseInt(one),Integer.parseInt(two),Integer.parseInt(three),Integer.parseInt(four));
			codeServlet cs = new codeServlet();
			String code = cs.returnCode();
			
			inherit.setCode(code);
			
			List<InheritanceModel> inheritanceList = inherit.getComplexity();
			request.setAttribute("inheritanceList", inheritanceList);
			request.getRequestDispatcher("Result.jsp").forward(request, response);
		}
		
		doGet(request,response);
		
	}

	
}
