package com.service;

import java.util.ArrayList;

import org.apache.commons.fileupload.FileItem;

import com.model.CustomFileCoupling;
import com.model.FileReadCoupling;
import com.model.LineCoupling;
import com.util.RemoveDuplicates;

public class MainCoupling {

	private boolean status;
	private ArrayList<CustomFileCoupling> fileList = new ArrayList<CustomFileCoupling>();
	private String fileType = "";
	//public static String WEBCONTENTDIR = "C:/Users/nusry/git/Last Clone/3rdyear_newproject/WebContent/";
	
	//for Azure hosting
	public static String WEBCONTENTDIR = "d:\\home\\site\\wwwroot\\webapps\\ROOT\\";
	
	//public static String WEBCONTENTDIR = "git/CodeComplexityCalculator/CCC/WebContent/";
	//Folder path inside the server( public static String WEBCONTENTDIR = "/opt/tomcat/webapps/ROOT/"; )

	public ArrayList<CustomFileCoupling> getFileList() {
		return fileList;
	}

	public void setFileList(ArrayList<CustomFileCoupling> fileList) {
		this.fileList = fileList;
	}
	
	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public boolean run() {

		CouplingService couplingService = new CouplingServiceImp(fileList);

		for (CustomFileCoupling file : this.fileList) {

			if (!(file.getFileName().contains("java") || file.getFileName().contains("cpp"))) {
				System.out.println("Wrong file type");
			} else {
				try {
					if (file.getFileName().contains("java")) {
						fileType = "java";
					} else {
						fileType = "cpp";
					}
					file.setFileType(fileType);
					FileReadCoupling fileRead = new FileReadCoupling(file.getFileName());
					FileReadServiceCoupling fileReadService = new FileReadServiceImpCoupling();

					fileReadService.openFile(fileRead, file);
					fileReadService.readFile(fileRead, file);
					fileReadService.closeFile(fileRead);
					status = true;
				} catch (Exception e) {
					e.printStackTrace();
					status = false;
				}
			}
		}
		if (this.fileList.size() > 1) {
			try {
				couplingService.process2();
				status = true;
			} catch (Exception e) {
				status = false;
				e.printStackTrace();
			}
		}else {
			couplingService.process1(fileList.get(0));
		}
		CouplingServiceImp.process3();
		return status;
	}

}
