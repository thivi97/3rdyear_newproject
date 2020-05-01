package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;


import com.dao.LoginDao;

@WebServlet("/UserProfile")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        
    	PrintWriter out = response.getWriter();
    	
    	String un = request.getParameter("uname");
    	String pwd = request.getParameter("password");
    	
    	HttpSession session = request.getSession(false);
    	if(session != null) 
    		session.setAttribute("name", un);
    		
    		if(LoginDao.validate(un, pwd)) {
    			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
    			rd.forward(request, response);
    		}
    		else {
    			out.print("Sorry username or password error");
    			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
    			rd.include(request, response);
    		}
    		
    		out.close();
    	}
        
    }

	

