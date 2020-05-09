package com.servlet;

import com.model.*;
import com.service.Main;
import com.util.UnzipUtility;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;


public class UploadServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String UPLOAD_DIRECTORY = Main.WEBCONTENTDIR + "uploads/";
		Main main = new Main();
		boolean status = false;
		if(ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				for(FileItem item : multiparts) {
					if(!item.isFormField()) {
						String name = new File(item.getName()).getName();
						if(name.contains(".zip")) {
							File file = new File(UPLOAD_DIRECTORY + name.split("\\.")[0]);
							//creating the directory
							boolean bool = file.mkdir();
							
							item.write(new File(UPLOAD_DIRECTORY + name));
							
							String zipFilePath = UPLOAD_DIRECTORY + "/" +  name;
							String destDirectory = UPLOAD_DIRECTORY;
							UnzipUtility unzipper = new UnzipUtility();
							try {
								unzipper.unzip(zipFilePath, destDirectory);
								Files.deleteIfExists(Paths.get(UPLOAD_DIRECTORY + name));
								
								File folder = new File(UPLOAD_DIRECTORY + name.split("\\.")[0]);
								File[] listOfFiles = folder.listFiles();
								
								ArrayList<CustomFile> fileList = new ArrayList<>();
								
								for(int i = 0; i < listOfFiles.length; i++) {
									if(listOfFiles[i].isFile()) {
										CustomFile codeFile = new CustomFile(listOfFiles[i].getName());
										codeFile.setFilePath(UPLOAD_DIRECTORY + name.split("\\.")[0] + "/");
										fileList.add(codeFile);
									}
								}
							}catch(Exception ex) {
								ex.printStackTrace();
							}
						}else if(!(name.contains("java") || name.contains("cpp"))) {
							System.out.println("Upload UnSuccessful. Wrong file format");
						}else {
							item.write(new File(UPLOAD_DIRECTORY + name));
							CustomFile file = new CustomFile(name);
							file.setFilePath(UPLOAD_DIRECTORY);
							main.getFileList().add(file);
						}
					}
				}
				
				status = main.run();
			}catch(Exception ex) {
				ex.printStackTrace();
				request.setAttribute("message", "File upload failed due to : "+ex);
				System.out.println("Upload UnSuccessful");
			}
		}else {
			request.setAttribute("mesage", "Sorry this servlet only handles file upload request");
		}
		if(status == true) {
			HttpSession session = request.getSession();
			session.setAttribute("fileList", main.getFileList());
			response.sendRedirect("inheritanceResult.jsp");
		}else {
			request.getRequestDispatcher("inheritance.jsp").forward(request, response);
		}
	}
	
}
