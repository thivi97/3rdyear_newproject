package com.model;

import java.util.ArrayList;

public class CustomFile {
	
	private String fileName;
	private String filePath;
	private String fileType;
	private int lastIndex;
	private ArrayList<Line> lineSet;
	private Inherit inheritance;
	
	
	public CustomFile(String fileName) {
		this.fileName = fileName;
		this.lineSet = null;
		this.inheritance = new Inherit(fileName);
	}
	
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
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
	public int getLastIndex() {
		return lastIndex;
	}
	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}
	public ArrayList<Line> getLineSet() {
		return lineSet;
	}
	public void setLineSet(ArrayList<Line> lineSet) {
		this.lineSet = lineSet;
	}
	public Inherit getInheritance() {
		return inheritance;
	}
	public void setInheritance(Inherit inheritance) {
		this.inheritance = inheritance;
	}
	
	
	

}
