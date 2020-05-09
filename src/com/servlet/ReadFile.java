package com.servlet;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	
	public String read()throws IOException{
		String fileName = "D:\\codes\\text.txt";
		
		StringBuilder filedata = new StringBuilder();
		File file = new File(fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		System.out.println("Read text file using BufferedReader");
		while((line = br.readLine()) != null) {
			//process the line
			System.out.println(line);
			filedata.append(System.lineSeparator());
			filedata.append(line);
			filedata.append(System.lineSeparator());
		}
		
		//close resources
		br.close();
		fr.close();
		return filedata.toString();
	}

}
