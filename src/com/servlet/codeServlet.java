package com.servlet;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.model.controlstructure;
import com.model.Inheritance;
import com.service.InheritanceService;

/**
 * Servlet implementation class codeServlet
 */
@WebServlet("/codeServlet")
public class codeServlet extends HttpServlet {
	static String code;
	private static final long serialVersionUID = 1L;
       
	
	   
	  
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public codeServlet() {
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
		 code =  request.getParameter("code");
		
		//System.out.println(code);
	
		String button = request.getParameter("button");
		//.out.println(code);
		if(button.equals("Size")) {
			


			request.getRequestDispatcher("WeightSize.jsp").forward(request, response);
		}
		if(button.equals("Method")) {
			

			request.getRequestDispatcher("WeightMethod.jsp").forward(request, response);
			}
			
		if(button.equals("Variable")) {

			request.getRequestDispatcher("WeightVariable.jsp").forward(request, response);
		}
		
		if(button.equals("Inheritance")) {
			InheritanceService inheritance = new InheritanceService();
			inheritance.setCode(code);
			List<Inheritance> inheritanceList = inheritance.getComplexity();
			request.setAttribute("inheritanceList", inheritanceList);
			request.getRequestDispatcher("result.jsp").forward(request, response);
			
		}
		if(button.equals("controlstructure")) {
			
			
		}
		
		
		if(button.equals("Coupling")) {
			

			request.getRequestDispatcher("WeightCoupling.jsp").forward(request, response);
		
		//response.getWriter().write(code);
		}
		if(button.equals("All-Factors")) {
			
			request.getRequestDispatcher("AllFactors.jsp").forward(request, response);
		}
	     
		
		doGet(request, response);
	}
	public String returnCode() {
		System.out.println(code);
		return code;
	}
}