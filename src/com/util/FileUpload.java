package com.util;

public class FileUpload {
	
	private static FileUpload fileInstanceSingleton;
	private String filePath,fileName,fileDir;
	
	public FileUpload() {}
	
	public static FileUpload getInstance() {
		if(fileInstanceSingleton == null) {
			synchronized(FileUpload.class) {
				fileInstanceSingleton = new FileUpload();
			}
		}
		return fileInstanceSingleton;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDir() {
		return fileDir;
	}

	public void setFileDir(String fileDir) {
		this.fileDir = fileDir;
	}
	
	
	
	
	

}
