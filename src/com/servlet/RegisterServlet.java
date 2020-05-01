package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Register;
import com.dao.RegisterDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private RegisterDao registerDao;

	public void init(){
		registerDao = new RegisterDao();
    }
    
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String uname = request.getParameter("uname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String conpassword = request.getParameter("conpassword");
        
        Register register = new Register();
        
        register.setFname(fname);
        register.setLname(lname);
        register.setUname(uname);
        register.setEmail(email);
        register.setPassword(password);
        register.setConpassword(conpassword);
        
        try {
        	registerDao.registeruser(register);
        }catch(Exception e){
        	e.printStackTrace();
        }
        
        response.sendRedirect("signup.jsp");
       

    }
}
