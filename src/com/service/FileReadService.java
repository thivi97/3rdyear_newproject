package com.service;

import com.model.CustomFile;
import com.model.FileRead;

public interface FileReadService {

	public void openFile(FileRead file, CustomFile fileobj);
	public void readFile(FileRead file, CustomFile fileobj);
	public void closeFile(FileRead file);
	
}
