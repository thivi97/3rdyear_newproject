package com.handler;

import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUploadHandlerInh
 */
@WebServlet("/FileUploadHandlerInh")
public class FileUploadHandlerInh extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String UPLOAD_DIRECTORY = "D:\\codes";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = null;
		String content;
		
		if(ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				for(FileItem item : multiparts) {
					if(!item.isFormField()) {
						name = new File(item.getName()).getName();
						item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
					}
				}
				
				content = new String(Files.readAllBytes(Paths.get(UPLOAD_DIRECTORY + File.separator + name)));
				request.setAttribute("message", content);
			}catch(Exception ex) {
				request.setAttribute("message", "File Upload Failed due to" + ex);
			}
		}else {
			request.setAttribute("message","Sorry this servlet only handles file upload request");
		}
		
		request.getRequestDispatcher("/inheritance.jsp").forward(request, response);
		
	}

}
