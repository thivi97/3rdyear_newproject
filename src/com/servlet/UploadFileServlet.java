package com.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.model.FileToAnalyze;
import com.model.SingleLineMethods;
import com.model.SingleLineStatement;
import com.model.SingleLineVariable;
import com.service.ComplexityMethodsService;
import com.service.ComplexitySizeService;
import com.service.ComplexityVariableService;

/**
 * Servlet implementation class UploadFileServlet
 */
@WebServlet("/UploadFileServlet")
@MultipartConfig(maxFileSize = 16177215) 
public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFileServlet() {
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
		System.out.println("working...");
        
		try {
			String submitBtn = request.getParameter("submitBtn");
			
			InputStream inputStream = null; // input stream of the upload file
	         
	        // obtains the upload file part in this multipart request
	        Part filePart = request.getPart("uploadFile");
	        if (filePart != null) {
	            // prints out some information for debugging
	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());
	             
	            // obtains input stream of the upload file
	            inputStream = filePart.getInputStream();
	            
	            if(filePart.getSize() == 0) {
	            	request.setAttribute("msg", "Selected file is empty or You have not selected a file");
					request.getRequestDispatcher("error.jsp").forward(request, response);
	            }
	        }

		   	//creating an InputSreamRteader object
		   	InputStreamReader isReader = new InputStreamReader(inputStream);
		 
		   	BufferedReader reader = new BufferedReader(isReader);
	   	
			if ("By Variable".equals(submitBtn)) {
			    System.out.println("Variable");
			    List<SingleLineVariable> singleLineVariables = new ArrayList<>();
			    
			    String lineV;
			    int x = 1;
	   			while((lineV = reader.readLine()) != null) {
	   				SingleLineVariable lineObj = new SingleLineVariable();
			   		lineObj.setLineNumber(x);
			   		lineObj.setStatement(lineV);
			   		singleLineVariables.add(lineObj);
			   		x++;
			   	}
			    
			    ComplexityVariableService complexityVariableService = new ComplexityVariableService();
			    singleLineVariables = complexityVariableService.calculateComplexityDueToVariable(singleLineVariables);
			    request.setAttribute("statementList", singleLineVariables);
			    request.getRequestDispatcher("resultVariable.jsp").forward(request, response);
			} else if ("By Statement".equals(submitBtn)) {
				System.out.println("Statements");
			    List<SingleLineStatement> singleLineStatements = new ArrayList<>();
			    
			    String line;
			    int x = 1;
	   			while((line = reader.readLine()) != null) {
	   				SingleLineStatement lineObj = new SingleLineStatement();
			   		lineObj.setLineNumber(x);
			   		lineObj.setStatement(line);
			   		singleLineStatements.add(lineObj);
			   		x++;
			   	}
			    
			    ComplexitySizeService complexitySizeService = new ComplexitySizeService();
			    singleLineStatements = complexitySizeService.calculateComplexityDueToStatmentSize(singleLineStatements);
			    request.setAttribute("statementList", singleLineStatements);
			    request.getRequestDispatcher("resultStatement.jsp").forward(request, response);

			} else if ("By Methods".equals(submitBtn)) {
			    System.out.println("Methods");
			    List<SingleLineMethods> singleLineMethods = new ArrayList<>();
			    
			    String lineM;
			    int x = 1;
	   			while((lineM = reader.readLine()) != null) {
	   				SingleLineMethods lineObj = new SingleLineMethods();
			   		lineObj.setLineNumber(x);
			   		lineObj.setStatement(lineM);
			   		singleLineMethods.add(lineObj);
			   		x++;
			   	}
			    
	   			ComplexityMethodsService complexityMethodsService = new ComplexityMethodsService();
			    singleLineMethods = complexityMethodsService.calculateComplexityDueToMethods(singleLineMethods);
			    request.setAttribute("statementList", singleLineMethods);
			    request.getRequestDispatcher("resultMethods.jsp").forward(request, response);
			}
			else {
			    System.out.println("Error");
			    request.setAttribute("msg", "Please try again");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}
		catch(Exception e) {
			System.out.println("Exception => UploadFileServlet");
			e.printStackTrace();
			
			request.setAttribute("msg", "Error in uploading");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
