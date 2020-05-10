package com.service;

import java.util.ArrayList;

import com.model.CustomFile;
import com.model.Line;
import com.util.RemoveDuplicates;
import com.model.FileRead;

import org.apache.commons.fileupload.FileItem;


public class Main {
	
	private boolean status;
	private ArrayList<CustomFile> fileList = new ArrayList<CustomFile>();
	private String fileType = "";
	public static String WEBCONTENTDIR = "git/";
	
	
	public ArrayList<CustomFile> getFileList() {
		return fileList;
	}
	
	
	public void setFileList(ArrayList<CustomFile> fileList) {
		this.fileList = fileList;
	}
	
	
	public String getFileType() {
		return fileType;
	}
	
	
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	public boolean run() {
		InheritanceService inheritanceService = new InheritanceServiceImp();
		for(CustomFile file : this.fileList) {
			if(!(file.getFileName().contains("java") || file.getFileName().contains("cpp"))) {
				System.out.println("Wrong file type");
			}else {
				try {
					if(file.getFileName().contains("java")) {
						fileType = "java";
					}else {
						fileType = "cpp";
					}
					
					file.setFileType(fileType);
					FileRead fileRead = new FileRead(file.getFileName());
					FileReadService fileReadService = new FileReadServiceImp();
					
					fileReadService.openFile(fileRead, file);
					fileReadService.readFile(fileRead, file);
					fileReadService.closeFile(fileRead);
					status = true;
				}catch(Exception e) {
					e.printStackTrace();
					status = false;
				}
			}
			
			if(this.fileList.size() > 1) {
				try {
					inheritanceService.process2(this.fileList);
					status = true;
				}catch(Exception e) {
					status = false;
					e.printStackTrace();
				}
			}else {
				inheritanceService.process1(fileList.get(0));
			}
			
			inheritanceService.process3(this.fileList);
			return status;
		}
		return status;
	}
	

	
	
	
}
