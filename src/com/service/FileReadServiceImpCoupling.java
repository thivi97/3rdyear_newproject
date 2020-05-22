package com.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import com.model.CustomFileCoupling;
import com.model.FileReadCoupling;
import com.model.LineCoupling;

public class FileReadServiceImpCoupling implements FileReadServiceCoupling{

	//Code segmant for open files
	@Override
	public void openFile(FileReadCoupling file, CustomFileCoupling fileobj) {
		try{
			file.setScanner(new Scanner(new File(fileobj.getFilePath() + file.getFileName()))); 
        }catch(Exception e){
            System.out.println("Couldn't find the file.");
        }
	}

	//Code segmant for read files and store in a object
	@Override
	public void readFile(FileReadCoupling file, CustomFileCoupling fileobj) {
		int count=1;
		ArrayList<LineCoupling> lineSet = new ArrayList<LineCoupling>();
		while(file.getScanner().hasNext()){
			LineCoupling line = new LineCoupling(count, file.getScanner().nextLine());
			lineSet.add(line);
			count++;
        }
		fileobj.setLineSet(lineSet);
		fileobj.setLastIndex(lineSet.size());
	}

	//Code segmant for close opened files
	@Override
	public void closeFile(FileReadCoupling file) {
		file.getScanner().close();
	}
	
}
