package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaClass.Size;
import com.javaClass.variable;
import com.javaClass.SizeVariable;
import com.servlet.UploadFileServlet;
/**
 * Servlet implementation class WeightMethodsServlet
 */
@WebServlet("/WeightMethodsServlet")
public class WeightMethodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeightMethodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
String button = request.getParameter("submit");
		
		
		String WmrtP =  request.getParameter("WmrtP");
		String WmrtC =  request.getParameter("WmrtC");
		String WmrtV =  request.getParameter("WmrtV");
		String Wpdtp =  request.getParameter("Wpdtp");
		String Wcdtp =  request.getParameter("Wcdtp");
		
		
		if(button.equals("save")) {
		SizeVariable m = new SizeVariable();
		m.weights(Integer.parseInt(WmrtP), Integer.parseInt(WmrtC), Integer.parseInt(WmrtV), Integer.parseInt(Wpdtp), Integer.parseInt(Wcdtp));
		codeServlet cs = new codeServlet();
		String code = cs.returnCode();
		
		m.setCode(code);
		String tb =	m.getTable();
		request.setAttribute("tb", tb);
		request.getRequestDispatcher("method.jsp").forward(request, response);
		}
		doGet(request, response);
	}



}
