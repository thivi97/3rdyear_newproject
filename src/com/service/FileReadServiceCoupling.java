package com.service;

import com.model.CustomFileCoupling;
import com.model.FileReadCoupling;

public interface FileReadServiceCoupling {
	
	public void openFile(FileReadCoupling file, CustomFileCoupling fileobj);
	public void readFile(FileReadCoupling file, CustomFileCoupling fileobj);
	public void closeFile(FileReadCoupling file);
	
}
