package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class FileUploads extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
    HttpSession session;
    ServletContext application;
    
    public FileUploads(){
    }
    

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        application = getServletContext();
        session = request.getSession();
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        
        if(isMultipart){
            FileItemFactory factory = new DiskFileItemFactory();
            
            ServletFileUpload upload = new ServletFileUpload(factory);
            
            try{
                List /* FileItem */ items = upload.parseRequest(request);
                Iterator iterator = items.iterator();
                while(iterator.hasNext()){
                    FileItem item = (FileItem) iterator.next();
                    if(!item.isFormField()){
                        String fileName = item.getName();
                        session.setAttribute("fileName", fileName);
                        
                        File path = new File("C://Users/User/Desktop/codes");
                        if(!path.exists()){
                            boolean status = path.mkdirs();
                        }
                        File uploadedFile = new File(path + "/" + fileName);
                        
                        System.out.println(uploadedFile.getAbsoluteFile());
                        item.write(uploadedFile);  
                    }
                }
                System.out.println("FILE: "+ session.getAttribute("filename"));
                response.sendRedirect("inheritance.jsp");
                response.sendRedirect("coupling.jsp");
            }catch(FileUploadException e){
                e.printStackTrace();
            }catch(Exception ex){
                Logger.getLogger(FileUploads.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
        
    }


}
