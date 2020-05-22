package com.model;

import java.util.ArrayList;

public class CustomFileCoupling {
	
	private String fileName;
	private String filePath;
	private String fileType;
	private int lastIndex;
	private ArrayList<LineCoupling> lineSet;
	private Coupling coupling;
	
	public CustomFileCoupling(String fileName) {
		this.fileName = fileName;
		this.lineSet = null;
		this.coupling = new Coupling(fileName);
	}

	public String getFileName() {
		return fileName;
	}
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public int getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	public void setLineSet(ArrayList<LineCoupling> lineSet) {
		this.lineSet = new ArrayList<LineCoupling>(lineSet);
	}
	
	public ArrayList<LineCoupling> getLineSet(){
		return lineSet;
	}

	public Coupling getCoupling() {
		return coupling;
	}

	public void setCoupling(Coupling coupling) {
		this.coupling = coupling;
	}

}
