package com.model;
import java.util.Scanner;

import com.service.MainCoupling;

import java.io.*;

public class FileReadCoupling {

    private Scanner scanner;
    private String fileName;
    
    public FileReadCoupling(String fName) {
		this.fileName = fName;
	}
    
    public Scanner getScanner() {
    	return scanner;
    }
    
    public void setScanner(Scanner scanner) {
    	this.scanner = scanner;
    }
    
    public String getFileName() {
    	return fileName;
    }
    

}
